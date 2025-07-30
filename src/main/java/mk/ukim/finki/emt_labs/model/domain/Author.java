package mk.ukim.finki.emt_labs.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt_labs.model.domain.Country;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @ManyToOne()
    private Country country;

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {

    }
}