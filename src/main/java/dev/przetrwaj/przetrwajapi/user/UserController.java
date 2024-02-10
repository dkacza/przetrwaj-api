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
    @PostMapping("/byId")
    public ResponseEntity<UserDTO> getUserById(@RequestParam long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


}
