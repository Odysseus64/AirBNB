package plasma.swagger.exam.service;


import lombok.AllArgsConstructor;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import plasma.airbnb.enums.Role;
import plasma.airbnb.model.User;
import plasma.swagger.exam.config.JwtUtils;
import plasma.swagger.exam.dto.auth.AuthRequest;
import plasma.swagger.exam.dto.auth.AuthResponse;
import plasma.swagger.exam.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {

        Authentication authentication;
        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));
        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());
        Role role = user.get().getRole();
        if (!BCrypt.checkpw(authRequest.getPassword(), user.get().getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }
        String generatedToken = jwtUtils.generateToken(authentication);
        System.out.println(generatedToken);
        return new AuthResponse(authRequest.getEmail(), role, generatedToken);
    }
}