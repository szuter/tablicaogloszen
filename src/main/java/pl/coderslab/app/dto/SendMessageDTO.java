package pl.coderslab.app.dto;

import org.hibernate.validator.constraints.NotBlank;


public class SendMessageDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String message;

    private Long recipient;

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

    public Long getRecipient() {
        return recipient;
    }

    public void setRecipient(Long recipient) {
        this.recipient = recipient;
    }
}