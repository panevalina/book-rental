package mk.ukim.finki.emt_labs.repository;


import mk.ukim.finki.emt_labs.model.views.AuthorsPerCountryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorsPerCountryViewRepository extends JpaRepository<AuthorsPerCountryView,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.authors_per_country", nativeQuery = true)
    void refreshMaterializedView();
}