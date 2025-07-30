package mk.ukim.finki.emt_labs.service.domain;

import mk.ukim.finki.emt_labs.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> findAll();
    Optional<Author> findById(long id);
    void deleteById(long id);
    Optional<Author> save(Author author);
    Optional<Author> update(long id,Author author);
}
