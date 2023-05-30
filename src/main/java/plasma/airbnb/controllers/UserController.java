package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.User;
import plasma.airbnb.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("home", service.findAll());
        return "/home/home";
    }
    @GetMapping("/user/getById/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        User user = service.findById(id);
        model.addAttribute("get", user);
        return ""; //Where?
    }
    @GetMapping("/user/save")
    public String createUser(@ModelAttribute("user") User user){
        service.save(user);
        return ""; //Where?
    }
    @GetMapping("/user/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
        return ""; //Where?
    }
    @GetMapping("/user/profile")
    public String profileUser(Model model){
        model.addAttribute("uss",service.findAll());
        return "/user/user-profile";
    }
}
/*
        UPDATE
        DELETE
        SHOW
        SAVE
*/