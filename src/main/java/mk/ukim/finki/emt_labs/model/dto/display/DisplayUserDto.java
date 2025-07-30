package mk.ukim.finki.emt_labs.model.dto.display;

import mk.ukim.finki.emt_labs.model.domain.Book;
import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.domain.enumerations.Role;

import java.util.List;

public record DisplayUserDto (String username, String name, Role role, List<Long> wishlist, List<Long>rented){

    public static DisplayUserDto from(User user){
        return new DisplayUserDto(
                user.getUsername(),
                user.getName(),
                user.getRole(),
                user.getBookWishlist().stream().map(Book::getId).toList(),
                user.getRentedBooks().stream().map(Book::getId).toList()
        );
    }
}
