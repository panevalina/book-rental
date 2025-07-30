package mk.ukim.finki.emt_labs.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emt_labs.repository.AuthorsPerCountryViewRepository;
import mk.ukim.finki.emt_labs.repository.BooksPerAuthorViewRepository;
import org.springframework.stereotype.Component;


@Component
public class MaterializedViewRefresher {
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;
    private final AuthorsPerCountryViewRepository authorsPerCountryViewRepository;

    public MaterializedViewRefresher(BooksPerAuthorViewRepository booksPerAuthorViewRepository, AuthorsPerCountryViewRepository authorsPerCountryViewRepository) {
        this.booksPerAuthorViewRepository = booksPerAuthorViewRepository;
        this.authorsPerCountryViewRepository = authorsPerCountryViewRepository;
    }

    @PostConstruct
    public void init() {
        booksPerAuthorViewRepository.refreshMaterializedView();
        authorsPerCountryViewRepository.refreshMaterializedView();
    }
}
