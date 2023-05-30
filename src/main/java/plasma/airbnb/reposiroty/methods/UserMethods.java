package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.User;

import java.util.List;

public interface UserMethods {
    void deleteById(Long id);
    void update(Long id, User user);
    User findById(Long id);
    User save(User user);
    List<User> findAll();
}
