package plasma.swagger.exam.service;


import com.example.exam.dto.Request.UserRequest;
import com.example.exam.dto.Response.UserResponse;
import com.example.exam.mapper.UserMapper;
import com.example.exam.model.User;
import com.example.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    public UserResponse registerUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new RuntimeException("This email is already have in!");
        }
        User savedUser = userRepository.save(userMapper.toUser(userRequest));
        return modelMapper.map(savedUser, UserResponse.class);
    }
}