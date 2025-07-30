package mk.ukim.finki.emt_labs.model.dto.create;

import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Role;

public record CreateUserDto(
        String username,
        String password,
        String repeatPassword,
        String name,
        Role role
) {

    public User toUser() {
        return new User(username, password, name, role);
    }
}
