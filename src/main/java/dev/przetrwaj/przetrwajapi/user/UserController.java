package dev.przetrwaj.przetrwajapi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/byId")
    public ResponseEntity<UserDTO> getUserById(@RequestParam long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PatchMapping("/byId")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @RequestParam long id) {
        return ResponseEntity.ok(userService.updateUserById(id, userDTO));
    }

    @DeleteMapping("/byId")
    public ResponseEntity<String> updateUser(@RequestParam long id) {
        boolean deleted = userService.deleteUserById(id);
        return deleted ? ResponseEntity.ok("User deleted") : ResponseEntity.ok("User not found");
    }


}
