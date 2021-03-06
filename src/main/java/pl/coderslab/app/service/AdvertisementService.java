package pl.coderslab.app.service;


import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dto.AdvertisementDTO;
import pl.coderslab.app.model.Advertisement;
import pl.coderslab.app.model.Comment;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.AdvertisementRepository;
import pl.coderslab.app.repositories.UserRepository;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Transactional
@Service
public class AdvertisementService {

    private UserRepository userRepository;
    private AdvertisementRepository advertisementRepository;

    public AdvertisementService(UserRepository userRepository, AdvertisementRepository advertisementRepository) {
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
    }


    public void addAdvertisement(AdvertisementDTO data, String email) {
        User user = userRepository.findByEmail(email);
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(data.getTitle());
        advertisement.setDescription(data.getDescription());
        advertisement.setUser(user);
        advertisement.setExpired(data.getExpired());
        if (!data.getImage().isEmpty()) {
            try {
                advertisement.setImage(IOUtils.toByteArray(data.getImage().getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (data.getId()!=null)
            advertisement.setId(data.getId());
        advertisementRepository.save(advertisement);
    }

    public Advertisement getAdvertisement(Long id) {
        return advertisementRepository.findOne(id);
    }

    public Advertisement showAdvertisement(Long id) {
        return advertisementRepository.findOne(id);
    }

    public List<Comment> commentList(Long id) {
        List<Comment> comments = advertisementRepository.findOne(id).getComments();
        Collections.reverse(comments);
        comments.size();
        return comments;
    }
}
