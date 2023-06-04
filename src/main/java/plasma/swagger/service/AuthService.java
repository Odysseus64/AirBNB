package plasma.swagger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.Role;
import plasma.airbnb.model.User;
import plasma.airbnb.reposiroty.UserRepository;
import plasma.swagger.config.jwt.JwtUtils;
import plasma.swagger.dto.request.LoginRequest;
import plasma.swagger.dto.request.UserRegisterRequest;
import plasma.swagger.dto.response.JWTResponse;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final JwtUtils jwtUtils;
    private PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterRequest userRegisterRequest) {
        User user = new User(userRegisterRequest.getEmail());
        user.setName(userRegisterRequest.getFullName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userRegisterRequest.getPassword()));

        if (repository.existsByEmail(userRegisterRequest.getEmail())) {
            throw new RuntimeException("The email " + userRegisterRequest.getEmail() + " is already in use!");
        }
        User savedUser = repository.save(user);
        String token = jwtUtils.generateToken(userRegisterRequest.getEmail());
        new JWTResponse(savedUser.getEmail(), token, "Neon", savedUser.getRole());
    }

    public JWTResponse authenticate(LoginRequest loginRequest) {
        User user = repository.findByEmail(loginRequest.getEmail()).orElseThrow(() ->
                new RuntimeException("User with email: " + loginRequest.getEmail() + " not found!"));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = jwtUtils.generateToken(user.getEmail());
        return new JWTResponse(user.getEmail(), token, "Neon", user.getRole());
    }
}