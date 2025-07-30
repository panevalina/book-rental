import React, { useState } from 'react';
import useBooks from "../../hooks/useBooks";
import useAuthors from "../../hooks/useAuthors";
import bookRepository from "../../repository/booksRepository";

const BooksPage = () => {
    const { books, loadBooks } = useBooks(); // ВАЖНО!
    const authors = useAuthors();

    const [isModalOpen, setIsModalOpen] = useState(false);
    const [editingBook, setEditingBook] = useState(null);
    const [formData, setFormData] = useState({
        name: "",
        category: "",
        author: ""
    });

    const getAuthorName = (authorId) => {
        const author = authors.find(a => a.id === authorId);
        return author ? `${author.name} ${author.surname}` : "Непознат автор";
    };

    const openModal = (book = null) => {
        if (book) {
            setEditingBook(book);
            setFormData({
                name: book.name,
                category: book.category,
                author: book.author
            });
        } else {
            setEditingBook(null);
            setFormData({ name: "", category: "", author: "" });
        }
        setIsModalOpen(true);
    };

    const closeModal = () => {
        setIsModalOpen(false);
        setEditingBook(null);
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if (editingBook) {
                await bookRepository.update(editingBook.id, formData);
            } else {
                await bookRepository.create(formData);
            }
            closeModal();
            loadBooks(); // Освежи ја листата без reload
        } catch (err) {
            console.error("Грешка при зачувување", err);
        }
    };

    const handleDelete = async (id) => {
        try {
            await bookRepository.delete(id);
            loadBooks(); // Освежи ја листата без reload
        } catch (err) {
            console.error("Грешка при бришење", err);
        }
    };

    return (
        <div>
            <h1>Книги</h1>
            <button onClick={() => openModal()}>+ Додади книга</button>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>
                        <p><strong>{book.name}</strong></p>
                        <p>{book.category}</p>
                        <p>{getAuthorName(book.author)}</p>
                        <button onClick={() => openModal(book)}>Измени</button>
                        <button onClick={() => handleDelete(book.id)}>Избриши</button>
                    </li>
                ))}
            </ul>

            {isModalOpen && (
                <div style={{
                    position: 'fixed', top: 0, left: 0, width: '100%',
                    height: '100%', backgroundColor: 'rgba(0,0,0,0.5)',
                    display: 'flex', alignItems: 'center', justifyContent: 'center'
                }}>
                    <div style={{
                        backgroundColor: 'white', padding: 20, borderRadius: 8,
                        width: '400px'
                    }}>
                        <h2>{editingBook ? "Измени книга" : "Додади нова книга"}</h2>
                        <form onSubmit={handleSubmit}>
                            <div>
                                <label>Име:</label>
                                <input
                                    name="name"
                                    value={formData.name}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div>
                                <label>Категорија:</label>
                                <input
                                    name="category"
                                    value={formData.category}
                                    onChange={handleChange}
                                    required
                                />
                            </div>
                            <div>
                                <label>Автор:</label>
                                <select
                                    name="author"
                                    value={formData.author}
                                    onChange={handleChange}
                                    required
                                >
                                    <option value="">-- Одбери автор --</option>
                                    {authors.map((a) => (
                                        <option key={a.id} value={a.id}>
                                            {a.name} {a.surname}
                                        </option>
                                    ))}
                                </select>
                            </div>
                            <div style={{ marginTop: 10 }}>
                                <button type="submit">Зачувај</button>
                                <button type="button" onClick={closeModal} style={{ marginLeft: 10 }}>Откажи</button>
                            </div>
                        </form>
                    </div>
                </div>
            )}
        </div>
    );
};

export default BooksPage;
