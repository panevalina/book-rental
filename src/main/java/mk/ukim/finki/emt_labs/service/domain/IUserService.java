package mk.ukim.finki.emt_labs.service.domain;

import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Role;
import mk.ukim.finki.emt_labs.model.projections.UserProjection;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, Role role);
    User login(String username, String password);
    User getAuthenticatedUser(String token);
    User findByUsername(String username);
    List<UserProjection> getAllUserNames();

}
