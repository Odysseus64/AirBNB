package plasma.swagger.exam.service;
import com.example.exam.dto.Request.StudentRequest;
import com.example.exam.dto.Response.StudentResponse;
import com.example.exam.exception.CustomRuntimeException;
import com.example.exam.mapper.StudentMapper;
import com.example.exam.mapper.UserMapper;
import com.example.exam.model.Student;
import com.example.exam.repository.StudentRepository;
import com.example.exam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;

    public StudentResponse registerStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByEmail(studentRequest.getEmail())) {
            throw new RuntimeException(
                    "This email is already have in!"
            );
        }
        userRepository.save(userMapper.toUser(studentRequest));
        Student savedStudent = studentRepository.save(studentMapper.toStudent(studentRequest));
        return modelMapper.map(savedStudent, StudentResponse.class);
    }

    public StudentResponse findStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Student not found with id: " + id));
        return modelMapper.map(student, StudentResponse.class);
    }

    public List<StudentResponse> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteStudentById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Student with id : " + id + " doesn't exist.");
        }
        studentRepository.deleteById(id);
    }

    public StudentResponse updateStudent(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Student not found with id " + id));
        modelMapper.map(studentRequest, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentResponse.class);
    }
}