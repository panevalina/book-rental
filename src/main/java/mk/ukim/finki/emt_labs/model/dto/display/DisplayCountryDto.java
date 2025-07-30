package mk.ukim.finki.emt_labs.model.dto.display;

import mk.ukim.finki.emt_labs.model.domain.Country;

import java.util.List;

public record DisplayCountryDto (Long id, String name, String continent){
    public Country toCountry(){
        return new Country(name,continent);
    }
    public static DisplayCountryDto from(Country country){
        return new DisplayCountryDto(country.getId(),country.getName(),country.getContinent());
    }
    public static List<DisplayCountryDto> from(List<Country> countryList){
        return countryList.stream()
                .map(c->new DisplayCountryDto(c.getId(),c.getName(),c.getContinent()))
                .toList();
    }
}
