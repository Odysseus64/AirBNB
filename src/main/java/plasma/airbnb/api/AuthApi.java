package plasma.airbnb.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.dto.request.LoginRequest;
import plasma.airbnb.dto.request.UserRegisterRequest;
import plasma.airbnb.dto.response.JWTResponse;
import plasma.airbnb.service.auth_service.AuthService;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final AuthService authService;

    @PostMapping("register")
    @PermitAll
    public String registrationPerson(@RequestBody UserRegisterRequest userRegisterRequest) {
        authService.registerUser( userRegisterRequest );
        return "Siuuu";
    }

    @PostMapping("login")
    @PermitAll
    public JWTResponse performLogin(@RequestBody LoginRequest loginResponse) {
        return authService.authenticate( loginResponse );
    }

}
