package mk.ukim.finki.emt_labs.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Category;


@Entity
@Data
@Table(name = "book")
public class Book {
    public Book() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book( String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}