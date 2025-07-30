package mk.ukim.finki.emt_labs.model.exceptions;
public class BookAlreadyInShoppingCartException extends RuntimeException {

    public BookAlreadyInShoppingCartException(Long id, String username) {
        super(String.format("Product with id: %d already exists in shopping cart for user with username %s", id, username));
    }
}
