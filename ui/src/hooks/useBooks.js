import { useEffect, useState } from "react";
import bookRepository from "../repository/booksRepository";

const useBooks = () => {
    const [books, setBooks] = useState([]);

    const loadBooks = () => {
        bookRepository
            .findAll()
            .then((response) => {
                setBooks(response.data);
            })
            .catch((error) => console.log(error));
    };

    useEffect(() => {
        loadBooks();
    }, []);

    return { books, loadBooks };
};

export default useBooks;
