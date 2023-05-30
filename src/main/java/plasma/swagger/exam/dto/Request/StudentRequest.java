package plasma.swagger.exam.dto.Request;

import com.example.exam.model.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private StudyFormat studyFormat;
}
