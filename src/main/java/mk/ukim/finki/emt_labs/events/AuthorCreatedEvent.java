package mk.ukim.finki.emt_labs.events;
import lombok.Getter;
import mk.ukim.finki.emt_labs.model.domain.Author;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;
@Getter
public class AuthorCreatedEvent extends ApplicationEvent {
    private final LocalDateTime when;

    public AuthorCreatedEvent(Author source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}
