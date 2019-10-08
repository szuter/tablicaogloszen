package pl.coderslab.app.model;

import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends AbstarctEntity {

    @NotBlank
    private String message;
    private LocalDateTime created;
    @Transient
    private String author;
    @Nullable
    @ManyToOne
    private User user;
    @ManyToOne
    private Advertisement advertisement;

    public Comment() {
        author = "Anonymous";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
        this.advertisement = advertisement;
    }
}
