package mk.ukim.finki.emt_labs.model.domain.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER, ROLE_LIBRARIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}

