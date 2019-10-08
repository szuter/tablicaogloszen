package pl.coderslab.app.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Entity
@Table(name = "advertisments")
public class Advertisement extends AbstarctEntity {


    @Lob
    private byte[] image;
    @NotBlank
    private String description;
    @Transient
    private String Base64Image;

    @Transient
    private String placeholderImage =
            "iVBORw0KGgoAAAANSUhEUgAAAPYAAADNCAMAAAC8cX2UAAAAe1BMVEXMzMz////k5OTQ0" +
                    "NDNzc35+fnZ2dkAAADBwcHV1dXS0tL29vbc3Nz8/PzJycnm5ubt7e3x8fFHR0" +
                    "e3t7exsbGYmJirq6tubm6goKAVFRUsLCxeXl6IiIh2dna+vr5mZmYhISE8PDy" +
                    "QkJAzMzNLS0sNDQ0eHh4+Pj5hYWEpP4mBAAAHnElEQVR4nO2d62KjLBBAWSGx" +
                    "3jCXJun2sm3T7X59/yf8EmNMVBDQQUQ4f/ZPNZ6gwzCMWRRe+dgcjvstQbOEP" +
                    "Dwdvn5XriEq/31+f4xiTGZqffLGMd29NLV/9gSbvjLdkJi+ftW03+jspc8Qst" +
                    "/cab/i2d7cDcifv5X2+3wf6RYEbUrtzR93rBHC2+dC+/vokvVpvHffZ+2/Tg3" +
                    "2SZseztqvsekLGRm8/wrR81wTMz74LUQb1wb7PNwf6Mc9bYQ/0asT+Vmd+ICe" +
                    "HNTGO+ReRDvNYVvk2KxdQCh6cFD7hNd2Ca/tEl7bJTjadCaoaZM8mAU5715ma" +
                    "+NfM4G34vDaXttr243X9tpe22t7bdvx2l7ba3ttry0mSwoyfZc+BD3ai1WQRl" +
                    "EcR1EarBKtAv3QoZ0EEamqVZTE6VqzhDrw2lnaOowspzbi0NpZTphlyWAxgow" +
                    "8wNqL9lBfoNGkBhxWO1tyTnf2ntITDqrdYX0inpA3pPYi4u42FJDpeANqM0J4" +
                    "83D45zvr91UCaucia4Qi8KQtiHtNEXDaicweadDTjseK9DslnHYkYY0w7OOdR" +
                    "D1PCaa96g5nJTSFvM2zlPY8JZR2JjXYp2i+GqDZpIwmPU4Jpb2S7H6AHO6kvP" +
                    "hY/VAobeHkVQE3iV1vMJorHwqknUj3YVOwYB5U0UQ9HwDSXslawxWm1ndXmKo" +
                    "eDKOdBVJxvIDCLEGT+xiKVaMajPaicw3S0AaJ5VlQO+lS8buE0U54p2GhfEey" +
                    "aDxVqt8ljPZa/h7vNd+0SJonJWrDDaMtl6JdtQFm7tZDRdXuIRjtXEUbD49pr" +
                    "MWeUmpuQntwwrJmXfVy7trseYOo5Go2anOSBJXarIXPNjcjVEh77YvkGTdHIP" +
                    "LDbd+8veR/lnxUsy5L6ypUyudqtuXk684VrvTzY9kKTPT9ykY1y9bbgeDksWR" +
                    "Ug6quSFYQZaorHZvh4tAZyN3mo9fShLNMQLmLZ/7cdTu9XGoOpb2GqpyeS7Cc" +
                    "vxFvsp1YSg032PaAZCwXjcYlUrPnOKmitNxEAaYtl7GIBvsaqVnLCsnqLBlVu" +
                    "yt7uiGKtGl5EkbpeyH1AUguHYLTXsgMhmBxeFvStGuh0qmBzF4g4P62+NETVX" +
                    "7u42Kz5WMtKY24EVGTtjCXoFF3glaf/Ot/LLu1eEZiexG0ZUcwwQjqAM35KVI" +
                    "4deNIYf4L26DVeXGiVsTmw3sf9bmv4DIRZ4LA7XgB9/JoKrBmpPVVpim/s3hB" +
                    "mApCN1+uYnbAJaJkmdX6UlUFFda1BcKqOXirbZIyvMUtiOyQVQYniR6o5oGCz" +
                    "9PQWJ0sGycl4r5LXrpNz0cqlaxKBFFNSxt9EixjUvyOAyLxMpBIH7ghCye/Fg" +
                    "pz143uxEjTSxPZepXnQZDnq7XMioi5zXFhmYjSATbdafAkXpHpzGvjnr/c1jm" +
                    "JTUJbNVDL0TXcU9BWqD+q0FWPn4C2bEubKl0FB/Pa3ZXvIXQ0HxvX7n7jYBj8" +
                    "qGZcm5XUQcEvOJjWVtoiVoVfuTOsLVtn7gsvqpnVlt9M6QlvL9CotlS9fxC85" +
                    "mOj2prylHs4bXomtRW2SfvDLjgY1FZqgegNexIzp60zT7mHOYkZ09YfzkqYqb" +
                    "kxbfX6WF9Yqbkp7Y56CjSsqrkh7WzU/9qgXXAwpC27aQtDu03PjHa/qmBv2s3" +
                    "HRrR11VO4tKrmJrRVd7QAaA63Ae2x8pTahTeimgFtnfUUHs29QC3anRshWusp" +
                    "XGg9NdehvUg7SrUj5ik16gUHHdo55dfutNdTuNSimgbtBea3E4y2AGlT2wvUo" +
                    "F1kYJzxHqGewqMW1eC1y0145la+0qs00NyPBLh2NSsz2rHGqafwoHfNx+Dat3" +
                    "V0a52r8kaJFm4TDLT2feLZ/CmhkRcgbUh1QcDaWS0Fq68Axqun8LgVHIC1G5s" +
                    "7968/mMpT7qn6OYG1m8nIrWw5bj2Fgybtdr5dFTZMLEBa6NFmNFDS0tt4OCvQ" +
                    "o83MPIv7fDWBBxtp0ua4BZmJegoTHdrcbCTQ1Himjg5tfv3A2GKziQZtqd9CN" +
                    "IwG7UnMUALgtRVeWDIHuLbKC0vmANeeRjoiAlpbX+MoKMDamQ3xDIFrWxHPEL" +
                    "i2Hbc4tLbBMrAaoNo25GcXQLXN7XSoAqk9em9CfwC1+72UZwZAbTP71f2A0za" +
                    "7waMInPa4HWYDAdPu85KxOaC0J1H0lwdK2471ZgWQtiXrzQoYbYOdKP2A0Tba" +
                    "k9EHEG2JH6ubGCDa1qw3KyC07VlvVkBoT2VjSwEAbbVfd5oGw7XNNY8OYLi2Z" +
                    "fnZhcHaFsYzBKBtYTxDw7Wty88K6FDtdGkl6TDtbGEpAOmKzXhtr+21vbbXth" +
                    "01bZIHs4C7aGZrF79dOgc41jztueO1XcJru4TXdomtg9rkAe1d1N6io3W7mcP" +
                    "BO/RuWZ8CBPE7+nRvtAn5Qh9757zx0z8UvrmmTdAhROHno2Pe+OnjpB2+Iafm" +
                    "MELfw7P2P7embnIMC+1wQx3yxo+/S+3wJXLGGz/8F161wxdXxhtvN+FNO3zZY" +
                    "gfECdlfrK/a4eaI5z6PEUxfn8O6dvh92MfxfIec4Jjufq6yN+0w/Ni87R5n6k" +
                    "0ej4fP3zfX/wFFnpwuXBLlrwAAAABJRU5ErkJggg==";

    private LocalDateTime created;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime expired;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "advertisement")
    private List<Comment> comments = new ArrayList<>();

    public Advertisement() {
        setImage(Base64.getDecoder().decode(getPlaceholderImage()));
    }

    public String getPlaceholderImage() {
        return placeholderImage;
    }

    public void setPlaceholderImage(String placeholderImage) {
        this.placeholderImage = placeholderImage;
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getBase64Image() {
        setBase64Image(Base64.getEncoder().encodeToString(getImage()));
        return Base64Image;
    }

    public void setBase64Image(String base64Image) {
        Base64Image = base64Image;
    }

    public LocalDateTime getExpired() {
        return expired;
    }

    public void setExpired(LocalDateTime expired) {
        this.expired = expired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
