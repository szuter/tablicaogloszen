package pl.coderslab.app.model;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "advertisments")
public class Advertisement extends AbstarctEntity {

    private byte[] image;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "advertisement")
    private List<Comment> comments = new ArrayList<>();

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
