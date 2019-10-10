package pl.coderslab.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dto.CommentDTO;
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

    public void addComment(CommentDTO data) {
        Comment comment = new Comment();
        comment.setMessage(data.getMessage());
        if (!(data.getUserId() == null)) {
            comment.setUser(userRepository.findOne(data.getUserId()));
        }
        if (!(data.getId()==null))
            comment.setId(data.getId());
        comment.setAdvertisement(advertisementRepository.findOne(data.getAdvertisemenetId()));
        commentRepository.save(comment);
    }
     public CommentDTO editComment(Comment comment){
         CommentDTO commentDTO = new CommentDTO();
         commentDTO.setUserId(comment.getUser().getId());
         commentDTO.setAdvertisemenetId(comment.getAdvertisement().getId());
         commentDTO.setMessage(comment.getMessage());
         commentDTO.setId(comment.getId());
         return commentDTO;
     }

    public Comment getComment(Long id){
        return commentRepository.findOne(id);
    }

    public Long getUserId(String email) {
        return userRepository.findByEmail(email).getId();
    }
}