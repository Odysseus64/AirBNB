package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.model.Product;
import plasma.airbnb.service.ImageService;
import plasma.airbnb.service.ProductService;

@Controller
@RequiredArgsConstructor
@RestController("/user")
public class UserController {
    private final ProductService productService;
    private final ImageService imageService;
    @GetMapping("/profile")
    @PreAuthorize("hashAuthority('USER')")
    public String profile(){
        productService.findAll();
        return "Your profile";
    }
    @GetMapping("/profile/image/{id}")
    @PreAuthorize("hashAuthority('USER')")
    public String profileImage(@PathVariable("id") Long id) {
        imageService.findById(id);
        return "Got a picture by id?";
    }


    // Damn bekbolsun how are you logging in now? How?
    @PostMapping("/auth/google")
    public String login(HttpSecurity http) throws Exception {
        http.cors()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
        return "You are logged in successfully.";
    }
}