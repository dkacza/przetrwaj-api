package dev.przetrwaj.przetrwajapi.auth;

import dev.przetrwaj.przetrwajapi.config.JwtService;
import dev.przetrwaj.przetrwajapi.user.Role;
import dev.przetrwaj.przetrwajapi.user.User;
import dev.przetrwaj.przetrwajapi.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()) throw new RuntimeException("Email already in use");
        User newUser = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                Role.USER);
        userRepository.save(newUser);
        String token = jwtService.generateToken(newUser);
        return new AuthenticationResponse(newUser, token);
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByEmail(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(user, token);
    }
}
