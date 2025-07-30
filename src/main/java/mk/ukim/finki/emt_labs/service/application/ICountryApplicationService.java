package mk.ukim.finki.emt_labs.service.application;

import mk.ukim.finki.emt_labs.model.dto.create.CreateCountryDto;
import mk.ukim.finki.emt_labs.model.dto.display.DisplayCountryDto;
import mk.ukim.finki.emt_labs.model.views.AuthorsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface ICountryApplicationService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(long id);
    void deleteById(long id);
    Optional<DisplayCountryDto> save(CreateCountryDto country);
    Optional<DisplayCountryDto> update(long id, CreateCountryDto country);

    List<AuthorsPerCountryView> findAllAuthorsPerCountry();
    AuthorsPerCountryView findAuthorsPerCountry(Long id);
    void refreshMaterializedView();
}
