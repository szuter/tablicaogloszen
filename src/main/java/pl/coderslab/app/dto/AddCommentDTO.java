package pl.coderslab.app.dto;

import com.sun.istack.internal.Nullable;
import org.hibernate.validator.constraints.NotBlank;

public class AddCommentDTO {

    @NotBlank
    private String message;
    @Nullable
    private Long userId;

    private Long advertisementId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAdvertisemenetId() {
        return advertisementId;
    }

    public void setAdvertisemenetId(Long advertisemenetId) {
        this.advertisementId = advertisemenetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
