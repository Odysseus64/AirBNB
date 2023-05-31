package plasma.swagger.exam.mapper;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import plasma.swagger.exam.dto.Request.StudentRequest;
import plasma.swagger.exam.model.Role;
import plasma.swagger.exam.model.Student;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final PasswordEncoder bCryptPasswordEncoder;

    public Student toStudent(StudentRequest studentRequest) {
        return Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .studyFormat(studentRequest.getStudyFormat())
                .email(studentRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(studentRequest.getPassword()))
                .role(Role.STUDENT)
                .build();
    }
}