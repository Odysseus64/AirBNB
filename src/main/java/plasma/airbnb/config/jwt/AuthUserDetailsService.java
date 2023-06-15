package plasma.config.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import plasma.model.User;
import plasma.reposiroty.UserRepository;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthUserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new RuntimeException("User with " + username + " not found!");
        }
        return new User(user.get());
    }
}
