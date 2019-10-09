package pl.coderslab.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dto.AddCommentDTO;
import pl.coderslab.app.model.Comment;
import pl.coderslab.app.repositories.AdvertisementRepository;
import pl.coderslab.app.repositories.CommentRepository;
import pl.coderslab.app.repositories.UserRepository;

@Service
@Transactional
public class CommentService {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private AdvertisementRepository advertisementRepository;


    public CommentService(CommentRepository commentRepository, UserRepository userRepository, AdvertisementRepository advertisementRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
    }

    public void addComment(AddCommentDTO data) {
        Comment comment = new Comment();
        comment.setMessage(data.getMessage());
        if (!(data.getUserId() == null)) {
            comment.setUser(userRepository.findOne(data.getUserId()));
        }
        comment.setAdvertisement(advertisementRepository.findOne(data.getAdvertisemenetId()));
        commentRepository.save(comment);
    }

    public Long getUserId(String email) {
        return userRepository.findByEmail(email).getId();
    }
}