package plasma.swagger.exam;

import com.example.exam.model.Role;
import com.example.exam.model.User;
import com.example.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class SpringBootAndSwaggerApplication {
    private final UserRepository userRepository;
    private final PasswordEncoder pass;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndSwaggerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Kurmanbek");
        user.setLastName("Pazylov");
        user.setEmail("kurmanbek@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(pass.encode("kurmanbek"));
        userRepository.save(user);
    }
}