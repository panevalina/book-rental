package mk.ukim.finki.emt_labs.repository;

import mk.ukim.finki.emt_labs.model.domain.Author;
import mk.ukim.finki.emt_labs.model.projections.AuthorProjection;
import mk.ukim.finki.emt_labs.model.projections.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByNameContains(String name);
    List<AuthorProjection> findAllProjectedBy();

}
