//package mk.ukim.finki.emt_labs.service.application.impl;
//
//import mk.ukim.finki.emt_labs.model.dto.bookDto.DisplayBookDto;
//import mk.ukim.finki.emt_labs.model.dto.wishlistDto.WishListDto;
//import mk.ukim.finki.emt_labs.model.domain.*;
//import mk.ukim.finki.emt_labs.repository.BookRepository;
//import mk.ukim.finki.emt_labs.service.application.old.WishListApplicationService;
//import mk.ukim.finki.emt_labs.service.domain.old.WishListService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class WishListApplicationImpl implements WishListApplicationService {
//    private final WishListService wishListService;
//    private final BookRepository bookRepository;
//
//    public WishListApplicationImpl(WishListService wishListService, BookRepository bookRepository) {
//        this.wishListService = wishListService;
//        this.bookRepository = bookRepository;
//    }
//
//    @Override
//    public List<DisplayBookDto> listAllBooksInWishList(Long cartId) {
//        List<Book> books = wishListService.listAllBooksInWishList(cartId);
//
//        return books.stream()
//                .map(DisplayBookDto::from)
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public Optional<WishListDto> getActiveWishList(String username) {
//        return wishListService.getActiveWishList(username).map(WishListDto::from);
//    }
//
//    @Override
//    public Optional<WishListDto> addBookToWishList(String username, Long productId) {
//        return wishListService.addBookToWishList(username, productId).map(WishListDto::from);
//    }
//
//    @Override
//    public boolean rentAllBooksFromWishList(String username) {
//        Optional<WishList> wishListOptional = wishListService.getActiveWishList(username);
//        if (wishListOptional.isPresent()) {
//            WishList wishList = wishListOptional.get();
//            for (Book book : wishList.getBooks()) {
//                if (book.getAvailableCopies() > 0) {
//                    book.setAvailableCopies(book.getAvailableCopies() - 1);
//                    bookRepository.save(book);
//                } else {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//}
