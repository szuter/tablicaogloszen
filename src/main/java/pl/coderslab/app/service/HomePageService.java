package pl.coderslab.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.Advertisement;
import pl.coderslab.app.repositories.AdvertisementRepository;
import pl.coderslab.app.repositories.UserRepository;

import java.util.List;

@Service
@Transactional
public class HomePageService {

    private UserRepository userRepository;
    private AdvertisementRepository advertisementRepository;


    public HomePageService(UserRepository userRepository,AdvertisementRepository advertisementRepository) {
        this.userRepository = userRepository;
        this.advertisementRepository = advertisementRepository;
    }

    public boolean isAdmin(String email) {
        return userRepository.findByEmail(email).getAccess().equals("ROLE_ADMIN");
    }
    public List<Advertisement> getAllAdvertisements(){
        return advertisementRepository.findAll();
    }
}
