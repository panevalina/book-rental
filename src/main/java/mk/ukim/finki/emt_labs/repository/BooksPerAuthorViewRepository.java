package mk.ukim.finki.emt_labs.repository;

import jakarta.transaction.Transactional;
import mk.ukim.finki.emt_labs.model.views.BooksPerAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BooksPerAuthorViewRepository extends JpaRepository<BooksPerAuthorView,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.books_per_author", nativeQuery = true)
    void refreshMaterializedView();
}
