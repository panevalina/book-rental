//package mk.ukim.finki.emt_labs.config;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.emt_labs.model.domain.*;
//import mk.ukim.finki.emt_labs.model.enumerations.Role;
//import mk.ukim.finki.emt_labs.model.enumerations.WishListStatus;
//import mk.ukim.finki.emt_labs.repository.*;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Component
//public class DataInitializer {
//    private final AuthorRepository authorRepository;
//    private final CountryRepository countryRepository;
//    private final BookRepository bookRepository;
//    private final UserRepository userRepository;
//    private final WishListRepository wishListRepository;
//    private final RentalRepository rentalRepository;
//    private final PasswordEncoder passwordEncoder;
//
//
//    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository, UserRepository userRepository, WishListRepository wishListRepository, RentalRepository rentalRepository, PasswordEncoder passwordEncoder) {
//        this.authorRepository = authorRepository;
//        this.countryRepository = countryRepository;
//        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
//        this.wishListRepository = wishListRepository;
//        this.rentalRepository = rentalRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostConstruct
//    public void init(){
//        Country uk = countryRepository.save(new Country("United Kingdom", "Europe"));
//        Country russia = countryRepository.save(new Country("Russia", "Europe"));
//        Country usa = countryRepository.save(new Country("USA", "North America"));
//
//        Author shakespeare = authorRepository.save(new Author("William", "Shakespeare", uk));
//        Author dostoevsky = authorRepository.save(new Author("Fyodor", "Dostoevsky", russia));
//        Author rowling = authorRepository.save(new Author("J.K.", "Rowling", usa));
//
//        Book book1 = bookRepository.save(new Book("The Comedy of Errors", Category.DRAMA, shakespeare, 5, true, false));
//        Book book2 = bookRepository.save(new Book("The Brothers Karamazov", Category.CLASSICS, dostoevsky, 4, true, false));
//        Book book3 = bookRepository.save(new Book("Harry Potter and the Sorcerer's Stone", Category.FANTASY, rowling, 10, true, false));
//
//
//        User user1 = userRepository.save(new User(
//                "lp",
//                passwordEncoder.encode("lp"),
//                "Lina",
//                "Paneva",
//                Role.ROLE_LIBRARIAN
//        ));
//
//        User user2 = userRepository.save(new User(
//                "user",
//                passwordEncoder.encode("user"),
//                "user",
//                "user",
//                Role.ROLE_USER
//        ));
//
//        WishList wishList1 = new WishList(user1);
//        wishList1.setBooks(List.of(book1, book2));
//        wishList1.setStatus(WishListStatus.CREATED);
//
//        WishList wishList2 = new WishList(user2);
//        wishList2.setBooks(List.of(book3));
//        wishList2.setStatus(WishListStatus.CREATED);
//
//        wishListRepository.save(wishList1);
//        wishListRepository.save(wishList2);
//
//        rentalRepository.save(new Rental(book1, user1));
//        rentalRepository.save(new Rental(book2, user1));
//        rentalRepository.save(new Rental(book3, user2));
//    }
//}
