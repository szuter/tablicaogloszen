package pl.coderslab.app.model;

import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends AbstarctEntity {

    @NotBlank
    private String message;
    private LocalDateTime date;
    @Nullable
    @ManyToOne
    private User user;
    @ManyToOne
    private Advertisement advertisement;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @PrePersist
    public void prePersist() {
        date = LocalDateTime.now();
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
