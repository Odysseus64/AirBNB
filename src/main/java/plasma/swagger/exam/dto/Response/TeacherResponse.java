package plasma.swagger.exam.dto.Response;

import lombok.Data;

@Data
public class TeacherResponse {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private String email;
}
