package mk.ukim.finki.emt_labs.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt_labs.model.domain.enumerations.WishListStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    private List<Book> books;

    @Enumerated(EnumType.STRING)
    private WishListStatus status;

    public WishList() {
    }

    public WishList(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.books = new ArrayList<>();
        this.status = WishListStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public WishListStatus getStatus() {
        return status;
    }

    public void setStatus(WishListStatus status) {
        this.status = status;
    }
}
