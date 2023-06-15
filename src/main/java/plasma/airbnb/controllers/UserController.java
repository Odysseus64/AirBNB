package plasma.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import plasma.reposiroty.UserRepository;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository service;
}