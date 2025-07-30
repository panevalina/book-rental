package mk.ukim.finki.emt_labs.model.dto.display;

import mk.ukim.finki.emt_labs.model.domain.Author;
import mk.ukim.finki.emt_labs.model.domain.Country;

import java.util.List;

public record DisplayAuthorDto(Long id, String name, String surname, Long country) {
    public Author toAuthor(Country country){
        return new Author(name,surname,country);
    }
    public static DisplayAuthorDto from(Author author){
        return new DisplayAuthorDto(author.getId(),author.getName(),author.getSurname(),author.getCountry().getId());
    }
    public static List<DisplayAuthorDto> from(List<Author> authors){
        return authors.stream()
                .map(a->new DisplayAuthorDto(a.getId(),a.getName(),a.getSurname(),a.getCountry().getId()))
                .toList();
    }
}
