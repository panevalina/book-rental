package mk.ukim.finki.emt_labs.repository;

import io.micrometer.common.lang.NonNull;
import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Role;
import mk.ukim.finki.emt_labs.model.projections.UserProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @NonNull
    @Override
//    @EntityGraph(
//            type = EntityGraph.EntityGraphType.FETCH,
//            attributePaths = {"bookWishlist"}
//    )
    List<User> findAll();
    List<UserProjection> findAllProjectedBy();
}

