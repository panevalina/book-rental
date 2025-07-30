package mk.ukim.finki.emt_labs.model.dto.create;

import mk.ukim.finki.emt_labs.model.domain.Author;
import mk.ukim.finki.emt_labs.model.domain.Book;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Category;

import java.util.List;

public record CreateBookDto(String name, Category category, Long author, Integer availableCopies){

    public Book toBook(Author author){
        return new Book(name,category,author,availableCopies);
    }

    public static CreateBookDto from(Book book){
        return new CreateBookDto(book.getName(),book.getCategory(),book.getAuthor().getId(),book.getAvailableCopies());
    }
    public static List<CreateBookDto> from(List<Book> books){
        return books.stream()
                .map(b->new CreateBookDto(b.getName(),b.getCategory(),b.getAuthor().getId(),b.getAvailableCopies()))
                .toList();
    }

}
