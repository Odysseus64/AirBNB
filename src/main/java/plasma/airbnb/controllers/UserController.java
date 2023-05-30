package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import plasma.airbnb.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
}