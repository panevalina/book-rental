//package mk.ukim.finki.emt_labs.web;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.servlet.http.HttpServletRequest;
//import mk.ukim.finki.emt_labs.model.domain.User;
//import mk.ukim.finki.emt_labs.model.dto.wishlistDto.WishListDto;
//import mk.ukim.finki.emt_labs.service.application.old.WishListApplicationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/wishlist")
//@Tag(name = "WishList API", description = "Endpoints for managing the wishlist")
//public class WishListController {
//
//    private final WishListApplicationService wishListApplicationService;
//
//    public WishListController(WishListApplicationService wishListApplicationService) {
//        this.wishListApplicationService = wishListApplicationService;
//    }
//
//    @Operation(
//            summary = "Get active wishlist",
//            description = "Retrieves the active wishlist for the logged-in user"
//    )
//    @ApiResponses(
//            value = {@ApiResponse(
//                    responseCode = "200",
//                    description = "Wishlist retrieved successfully"
//            ), @ApiResponse(responseCode = "404", description = "Wishlist not found")}
//    )
//    @GetMapping
//    public ResponseEntity<WishListDto> getActiveWishList(HttpServletRequest req) {
//        String username = req.getRemoteUser();
//        return wishListApplicationService.getActiveWishList(username)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @Operation(
//            summary = "Add book to wishlist",
//            description = "Adds a book to the wishlist for the logged-in user if there are available copies"
//    )
//    @ApiResponses(
//            value = {@ApiResponse(
//                    responseCode = "200", description = "Book added to wishlist successfully"
//            ), @ApiResponse(
//                    responseCode = "400",
//                    description = "Invalid request"
//            ), @ApiResponse(responseCode = "404", description = "Book not found"),
//                    @ApiResponse(responseCode = "409", description = "No available copies of the book")}
//    )
//    @PostMapping("/add-book/{id}")
//    public ResponseEntity<WishListDto> addBookToWishList(
//            @PathVariable Long id,
//            Authentication authentication
//    ) {
//        System.out.println("Received book ID: " + id);
//        try {
//            User user = (User) authentication.getPrincipal();
//            System.out.println("User found: " + user.getUsername());
//
//            return wishListApplicationService.addBookToWishList(user.getUsername(), id)
//                    .map(ResponseEntity::ok)
//                    .orElse(ResponseEntity.notFound().build());
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Логирај ја грешката
//            return ResponseEntity.badRequest().build();
//        }
//    }
//
//
//    @Operation(
//            summary = "Rent all books from wishlist",
//            description = "Rents all books from the user's wishlist and reduces the available copies"
//    )
//    @ApiResponses(
//            value = {@ApiResponse(
//                    responseCode = "200",
//                    description = "Books rented successfully"
//            ), @ApiResponse(responseCode = "404", description = "Wishlist not found")}
//    )
//    @PostMapping("/rent-all")
//    public ResponseEntity<String> rentAllBooksFromWishList(HttpServletRequest req) {
//        String username = req.getRemoteUser();
//        boolean success = wishListApplicationService.rentAllBooksFromWishList(username);
//        if (success) {
//            return ResponseEntity.ok("Books rented successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//}
