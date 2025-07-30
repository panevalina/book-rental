package mk.ukim.finki.emt_labs.repository;

import mk.ukim.finki.emt_labs.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByNameContains(String name);
}
