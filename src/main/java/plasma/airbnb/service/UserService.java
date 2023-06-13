package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plasma.model.User;
import plasma.reposiroty.UserRepository;
import plasma.reposiroty.methods.UserMethods;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserMethods {
    private final UserRepository repository;

    @Override
    public void deleteById(Long id) {
        try {
            log.info("Deleting user with id: {}", id);
            repository.deleteById(id);
        } catch (Exception exception) {
            log.error("Error while deleting user: {}", exception.getMessage());
            throw new RuntimeException("Failed to delete user", exception);
        }
    }


    @Override
    public void update(Long id, User user) {
        try {
            User uss = repository.findById(id).orElseThrow();
            uss.setEmail(user.getEmail());
            uss.setPassword(user.getPassword());
            uss.setName(user.getName());
            uss.setAddress(user.getAddress());
            uss.setDescription(user.getDescription());
            uss.setPhoneNumber(user.getPhoneNumber());
            uss.setImage(user.getImage());
            repository.save(uss);
            log.info("User updated: {}", uss);
            log.info("User finding with id: {}", id);
        } catch (Exception exception) {
            log.error("Log: Error while updating user: {}", exception.getMessage());
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public User findById(Long id) {
        try {
            log.info("Finding user with id: {}", id);
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        } catch (Exception exception) {
            log.error("Error while finding user: {}", exception.getMessage());
            throw new RuntimeException("Failed to find user", exception);
        }
    }

    @Override
    public User save(User user) {
        try {
            log.info("Saving user: {}", user);
            return repository.save(user);
        } catch (Exception exception) {
            log.error("Error while saving user: {}", exception.getMessage());
            throw new RuntimeException("Failed to save user", exception);
        }
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}