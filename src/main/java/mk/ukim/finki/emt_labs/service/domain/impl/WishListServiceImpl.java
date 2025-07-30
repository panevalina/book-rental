//package mk.ukim.finki.emt_labs.service.domain.impl;
//
//import mk.ukim.finki.emt_labs.model.dto.bookDto.DisplayBookDto;
//import mk.ukim.finki.emt_labs.model.domain.*;
//import mk.ukim.finki.emt_labs.model.domain.enumerations.WishListStatus;
//import mk.ukim.finki.emt_labs.model.exceptions.BookAlreadyInShoppingCartException;
//import mk.ukim.finki.emt_labs.model.exceptions.BookNotFoundException;
//import mk.ukim.finki.emt_labs.model.exceptions.ShoppingCartNotFoundException;
//import mk.ukim.finki.emt_labs.repository.BookRepository;
//import mk.ukim.finki.emt_labs.repository.WishListRepository;
//import mk.ukim.finki.emt_labs.service.application.AuthorApplicationService;
//import mk.ukim.finki.emt_labs.service.application.BookApplicationService;
//import mk.ukim.finki.emt_labs.service.domain.old.UserService;
//import mk.ukim.finki.emt_labs.service.domain.old.WishListService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WishListServiceImpl implements WishListService {
//    private final WishListRepository wishListRepository;
//    private final UserService userService;
//    private final BookApplicationService bookService;
//    private final AuthorApplicationService authorService;
//    private final BookRepository bookRepository;
//
//    public WishListServiceImpl(WishListRepository wishListRepository, UserService userService, BookApplicationService bookService, AuthorApplicationService authorService, BookRepository bookRepository) {
//        this.wishListRepository = wishListRepository;
//        this.userService = userService;
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.bookRepository = bookRepository;
//    }
//
//    @Override
//    public List<Book> listAllBooksInWishList(Long cartId) {
//        if (wishListRepository.findById(cartId).isEmpty())
//            throw new ShoppingCartNotFoundException(cartId);
//        return wishListRepository.findById(cartId).get().getBooks();
//
//    }
//
//    @Override
//    public Optional<WishList> getActiveWishList(String username) {
//        User user = userService.findByUsername(username);
//
//        return Optional.of(wishListRepository.findByUserAndStatus(
//                user,
//                WishListStatus.CREATED
//        ).orElseGet(() -> wishListRepository.save(new WishList(user))));
//
//    }
//
//    public Optional<WishList> addBookToWishList(String username, Long productId) {
//        if (getActiveWishList(username).isPresent()) {
//            WishList wishList = getActiveWishList(username).get();
//
//            Book book = bookRepository.findById(productId)
//                    .orElseThrow(() -> new BookNotFoundException(productId));
//
//            if (book.getAvailableCopies() > 0) {
//                if (!wishList.getBooks().stream().anyMatch(i -> i.getId().equals(productId))) {
//                    wishList.getBooks().add(book);
//                    return Optional.of(wishListRepository.save(wishList));
//                } else {
//                    throw new BookAlreadyInShoppingCartException(productId, username);
//                }
//            } else {
//                throw new RuntimeException("No available copies of the book.");
//            }
//        }
//        return Optional.empty();
//    }
//
//
//
//
//    public Optional<Book> mapDisplayBookDtoToBook(DisplayBookDto displayBookDto) {
//        Category category = Category.valueOf(displayBookDto.getCategoryName().toUpperCase());
//
//        Optional<Author> author = authorService.findByName(displayBookDto.getAuthorName());
//
//        if (author.isPresent()) {
//            Book book = new Book(
//                    displayBookDto.getName(),
//                    category,
//                    author.get(),
//                    displayBookDto.getAvailableCopies(),
//                    displayBookDto.getIsInGoodCondition(),
//                    displayBookDto.getIsRented()
//            );
//            return Optional.of(book);
//        }
//        return Optional.empty();
//    }
//
//}
//
