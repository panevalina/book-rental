package mk.ukim.finki.emt_labs.service.application;

import mk.ukim.finki.emt_labs.model.dto.create.CreateAuthorDto;
import mk.ukim.finki.emt_labs.model.dto.display.DisplayAuthorDto;
import mk.ukim.finki.emt_labs.model.projections.AuthorProjection;
import mk.ukim.finki.emt_labs.model.views.BooksPerAuthorView;

import java.util.List;
import java.util.Optional;

public interface IAuthorApplicationService {
    List<DisplayAuthorDto> findAll();
    Optional<DisplayAuthorDto> findById(long id);
    void deleteById(long id);
    Optional<DisplayAuthorDto> save(CreateAuthorDto author);
    Optional<DisplayAuthorDto> update(long id,CreateAuthorDto author);

    List<BooksPerAuthorView> findAllBooksPerAuthor();
    BooksPerAuthorView findBooksPerAuthor(Long id);
    void refreshMaterializedView();
    List<AuthorProjection> getAllAuthorNames();

}