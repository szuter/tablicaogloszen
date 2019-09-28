package pl.coderslab.app.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.dto.RegistrationFormDTO;
import pl.coderslab.app.model.User;
import pl.coderslab.app.repositories.UserRepository;


@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0) {
            return false;
        } else
            return true;
    }

    public void registerUser(RegistrationFormDTO data) {
        User user = new User();
        user.setAccess("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setEmail(data.getEmail());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        userRepository.save(user);

    }
}
