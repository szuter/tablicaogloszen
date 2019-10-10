package pl.coderslab.app.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message extends AbstractEntity {

    @NotBlank
    private String title;
    @NotBlank
    private String message;

    @ManyToOne
    private User sender;
    @ManyToOne
    private User recipient;

    private LocalDateTime created;

    public LocalDateTime getCreated() {
        return created;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }
}
