package mk.ukim.finki.emt_labs.repository;

import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.domain.WishList;
import mk.ukim.finki.emt_labs.model.domain.enumerations.WishListStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    Optional<WishList> findByUserAndStatus(User user, WishListStatus status);
}
