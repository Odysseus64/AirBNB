package plasma.swagger.exam.api;


import com.example.exam.dto.auth.AuthRequest;
import com.example.exam.dto.auth.AuthResponse;
import com.example.exam.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/login")
    @PermitAll
    public AuthResponse authenticated(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}