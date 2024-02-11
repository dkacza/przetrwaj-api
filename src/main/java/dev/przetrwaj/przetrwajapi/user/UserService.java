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
    UserDTO updateUserById(long id, UserDTO newUserDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        else {
            if (newUserDetails.getFirstName() != null && !newUserDetails.getFirstName().equals("")) user.setFirstName(newUserDetails.getFirstName());
            if (newUserDetails.getLastName() != null && !newUserDetails.getLastName().equals("")) user.setLastName(newUserDetails.getLastName());
        }
        userRepository.save(user);
        return new UserDTO(user);
    }

    public boolean deleteUserById(long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        };
        return false;
    }
}
