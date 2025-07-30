package mk.ukim.finki.emt_labs.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.emt_labs.model.dto.create.CreateAuthorDto;
import mk.ukim.finki.emt_labs.service.application.IAuthorApplicationService;
import mk.ukim.finki.emt_labs.service.application.impl.CountryApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Authors", description = "Author management API for librarians")
public class AuthorController {

    private final IAuthorApplicationService authorApplicationService;
    private final CountryApplicationService countryApplicationService;

    public AuthorController(IAuthorApplicationService authorApplicationService, CountryApplicationService countryApplicationService) {
        this.authorApplicationService = authorApplicationService;
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    @Operation(summary = "List all authors")
    public ResponseEntity<?> listAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "List specific author")
    public ResponseEntity<?> listAuthor(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new author", description = "Adds an author with details provided in the request body")
    public ResponseEntity<?> addAuthor(@RequestBody CreateAuthorDto authorDto) {
        return ResponseEntity.ok(authorApplicationService.save(authorDto));
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit an author", description = "Edits an existing author's details")
    public ResponseEntity<?> editAuthor(@RequestBody CreateAuthorDto authorDto, @PathVariable Long id) {
        return ResponseEntity.ok(authorApplicationService.update(id, authorDto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete an author", description = "Deletes an author by its ID")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        authorApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/by-country")
    @Operation(
            summary = "Displays the number of authors per country",
            description = "This method returns a list with the number of authors per country. It is used to retrieve data for all countries and the number of authors in each."
    )
    public ResponseEntity<?> findAllNumberOfAuthorsPerCountry() {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findAllAuthorsPerCountry());
    }


    @GetMapping("/by-country/{id}")
    @Operation(
            summary = "Displays the number of authors for a specific country",
            description = "This method returns the number of authors for a specific country identified by `id`. It is used to retrieve the exact number of authors for a given country."
    )
    public ResponseEntity<?> findNumberOfAuthorsPerCountry(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findAuthorsPerCountry(id));
    }


    @GetMapping("/names")
    @Operation(summary = "Get all author names", description = "Returns the name and surname of all authors")
    public ResponseEntity<?> getAuthorNames() {
        return ResponseEntity.ok(authorApplicationService.getAllAuthorNames());
    }

}