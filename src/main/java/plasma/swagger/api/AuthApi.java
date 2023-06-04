package plasma.swagger.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;
import plasma.swagger.dto.request.LoginRequest;
import plasma.swagger.dto.request.UserRegisterRequest;
import plasma.swagger.dto.response.JWTResponse;
import plasma.swagger.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("register")
    @PermitAll
    public String registrationPerson(@RequestBody UserRegisterRequest userRegisterRequest) {
        authService.registerUser( userRegisterRequest );
        return "working";
    }

    @PostMapping("login")
    @PermitAll
    public JWTResponse performLogin(@RequestBody LoginRequest loginResponse) {
        return authService.authenticate( loginResponse );
    }
}
