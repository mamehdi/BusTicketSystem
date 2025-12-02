package ir.maktabsharif.busticketsystem.service;

import ir.maktabsharif.busticketsystem.enums.Gender;
import ir.maktabsharif.busticketsystem.model.AppUser;
import ir.maktabsharif.busticketsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    public AppUser createUser(String username, String fullName, String planPassword,
                              Gender gender){
        AppUser user=AppUser.builder().username(username.trim()).fullName(fullName.trim())
                .password(passwordEncoder.encode(planPassword)).gender(gender)
                .role("ROLE_USER").build();
        return userRepository.save(user);
    }
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username.trim());
    }
    public Optional<AppUser> findByFullName(String fullName) {
        return userRepository.findByFullName(fullName.trim());
    }
    public Optional<AppUser> findById(Long id){
        return userRepository.findById(id);
    }
}
