package plasma.swagger.exam.mapper;

import com.example.exam.dto.Request.TeacherRequest;
import com.example.exam.model.Role;
import com.example.exam.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
                .role(Role.TEACHER)
                .build();
    }
}