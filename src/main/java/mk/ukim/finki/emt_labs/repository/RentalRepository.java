package mk.ukim.finki.emt_labs.repository;

import mk.ukim.finki.emt_labs.model.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
