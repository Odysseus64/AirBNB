package plasma.swagger.exam.service;

import com.example.exam.dto.Request.CourseRequest;
import com.example.exam.dto.Response.CompanyResponse;
import com.example.exam.dto.Response.CourseResponse;
import com.example.exam.exception.CustomRuntimeException;
import com.example.exam.model.Course;
import com.example.exam.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CompanyResponse createCourse(CourseRequest courseRequest) {
        Course course = modelMapper.map(courseRequest, Course.class);
        course = courseRepository.save(course);
        return modelMapper.map(course, CompanyResponse.class);
    }

    public CourseResponse findCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Course with id: " + id+" not found"));
        return modelMapper.map(course, CourseResponse.class);
    }

    public List<CourseResponse> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(course -> modelMapper.map(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteCourseById(Long id) {
        boolean exists = courseRepository.existsById(id);
        if (!exists) {
            throw new CustomRuntimeException("Course with id : " + id + " doesn't exist.");
        }
        courseRepository.deleteById(id);
    }

    public CourseResponse updateCourseById(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Course with id " + id+" not found"));
        modelMapper.map(courseRequest, course);
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseResponse.class);
    }
}