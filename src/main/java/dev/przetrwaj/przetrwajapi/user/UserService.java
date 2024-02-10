package dev.przetrwaj.przetrwajapi.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        else return new UserDTO(user);
    }
    List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }
}
