package plasma.swagger.exam.mapper;


import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import plasma.airbnb.model.User;
import plasma.swagger.exam.dto.Request.StudentRequest;
import plasma.swagger.exam.dto.Request.TeacherRequest;
import plasma.swagger.exam.dto.Request.UserRequest;
import plasma.swagger.exam.model.Role;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public User toUser(UserRequest userRequest) {
        return User.builder()
                .firstName((userRequest.getFirstName()))
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public User toUser(StudentRequest studentRequest) {
        return User.builder()
                .firstName((studentRequest.getFirstName()))
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }

    public User toUser(TeacherRequest teacherRequest) {
        return User.builder()
                .firstName((teacherRequest.getFirstName()))
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role.TEACHER)
                .build();
    }
}