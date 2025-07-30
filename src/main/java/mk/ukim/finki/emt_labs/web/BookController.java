package mk.ukim.finki.emt_labs.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emt_labs.model.dto.create.CreateBookDto;
import mk.ukim.finki.emt_labs.security.JwtConstants;
import mk.ukim.finki.emt_labs.service.application.IAuthorApplicationService;
import mk.ukim.finki.emt_labs.service.application.IBookApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/books")
@Tag(name = "Books", description = "Book management API for librarians")
@RestController
public class BookController {

    private final IBookApplicationService bookApplicationService;
    private final IAuthorApplicationService authorApplicationService;

    public BookController(IBookApplicationService bookApplicationService, IAuthorApplicationService authorApplicationService) {

        this.bookApplicationService = bookApplicationService;
        this.authorApplicationService = authorApplicationService;
    }

    @GetMapping
    @Operation(summary = "List all books")
    public ResponseEntity<?> listAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookApplicationService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "List specific books")
    public ResponseEntity<?> findBookById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookApplicationService.findById(id));
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new book", description = "Adds a book with details provided in the request body")
    public ResponseEntity<?> addBook(@RequestBody CreateBookDto bookDto) {
        return ResponseEntity.ok(bookApplicationService.save(bookDto));
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit a book", description = "Edits an existing book's details")
    public ResponseEntity<?> editBook(@RequestBody CreateBookDto bookDto, @PathVariable Long id) {
        return ResponseEntity.ok(bookApplicationService.update(id, bookDto));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete a book", description = "Deletes a book by its ID")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookApplicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public String extractTokenFromRequest(HttpServletRequest request){
        String headerValue = request.getHeader(JwtConstants.HEADER);
        return headerValue.substring(JwtConstants.TOKEN_PREFIX.length());
    }

    @PostMapping("/wishlist/add/{id}")
    @Operation(summary = "Add book to wishlist", description = "Adds a specific book to the authenticated user's wishlist")
    public ResponseEntity<?> addBookToWishList(@PathVariable Long id,HttpServletRequest request) {

        bookApplicationService.addBookToWishList(id,extractTokenFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/wishlist/remove/{id}")
    @Operation(summary = "Remove book from wishlist", description = "Removes a specific book from the authenticated user's wishlist")
    public ResponseEntity<?> removeBookFromWishList(@PathVariable Long id,HttpServletRequest request) {
        bookApplicationService.removeBookFromWishList(id,extractTokenFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/wishlist")
    @Operation(summary = "List all books in wishlist", description = "Retrieves all books from the authenticated user's wishlist")
    public ResponseEntity<?> listAllInWishList(HttpServletRequest request) {
        return ResponseEntity.ok(bookApplicationService.findAllInWishList(extractTokenFromRequest(request)));
    }

    @PostMapping("/rent/all")
    @Operation(summary = "Rent all books from wishlist", description = "Rents all books present in the authenticated user's wishlist")
    public ResponseEntity<?> rentAllFromWishList(HttpServletRequest request) {
        boolean result = bookApplicationService.rentAllFromWishList(extractTokenFromRequest(request));
        return ResponseEntity.ok(result);
    }

    @PostMapping("/rent/{id}")
    @Operation(summary = "Rent a book", description = "Rents a specific book by its ID from the available stock")
    public ResponseEntity<?> rentBook(@PathVariable Long id, HttpServletRequest request) {
        boolean result = bookApplicationService.rentBook(id,extractTokenFromRequest(request));
        return ResponseEntity.ok(result);
    }

    @PostMapping("/return/{id}")
    @Operation(summary = "Return a rented book", description = "Returns a specific rented book by its ID, increasing available copies")
    public ResponseEntity<?> returnBook(@PathVariable Long id, HttpServletRequest request) {
        bookApplicationService.returnBook(id,extractTokenFromRequest(request));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-author")
    @Operation(summary = "List number of books per author for every author")
    public ResponseEntity<?> findAllNumberOfBooksPerAuthor() {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findAllBooksPerAuthor());
    }

    @GetMapping("/by-author/{id}")
    @Operation(summary = "List number of books per author for a given author")
    public ResponseEntity<?> findNumberOfBooksPerAuthor(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorApplicationService.findBooksPerAuthor(id));
    }
}