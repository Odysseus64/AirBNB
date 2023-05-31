package plasma.swagger.exam.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import plasma.swagger.exam.dto.Request.TeacherRequest;
import plasma.swagger.exam.model.Role;
import plasma.swagger.exam.model.Teacher;

@Component
@RequiredArgsConstructor
public class TeacherMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public Teacher toTeacher(TeacherRequest teacherRequest) {
        return Teacher.builder()
                .firstName(teacherRequest.getFirstName())
                .lastName(teacherRequest.getLastName())
                .email(teacherRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(teacherRequest.getPassword()))
                .role(Role)
                .build();
    }
}