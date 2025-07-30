package mk.ukim.finki.emt_labs.listeners;

import mk.ukim.finki.emt_labs.events.AuthorChangedEvent;
import mk.ukim.finki.emt_labs.events.AuthorCreatedEvent;
import mk.ukim.finki.emt_labs.events.AuthorDeletedEvent;
import mk.ukim.finki.emt_labs.service.application.ICountryApplicationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuthorEventHandlers {
    private final ICountryApplicationService countryApplicationService;

    public AuthorEventHandlers(ICountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }
    @EventListener
    public void onAuthorCreated(AuthorCreatedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onAuthorDeleted(AuthorDeletedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onAuthorChanged(AuthorChangedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
}
