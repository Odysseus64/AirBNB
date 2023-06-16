package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.User;
import plasma.airbnb.reposiroty.UserRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/{id}/favorites")
    public void addToFavorites(@PathVariable("id")Long userId,@RequestBody String item){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        user.saveToFavorites(item);
        userRepository.save(user);
    }

    @DeleteMapping("/{id}/favorites")
    public void deleteFromFavorites(@PathVariable("id") Long userId,@RequestBody String item){
     User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
      user.deleteToFavorites(item);
      userRepository.delete(user);
    }
}