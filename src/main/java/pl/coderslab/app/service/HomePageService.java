package pl.coderslab.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.UserRepository;

@Service
@Transactional
public class HomePageService {

    private UserRepository userRepository;

    public HomePageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isAdmin(String email) {
        return userRepository.findByEmail(email).getAccess().equals("ROLE_ADMIN") ? true : false;
    }
}
