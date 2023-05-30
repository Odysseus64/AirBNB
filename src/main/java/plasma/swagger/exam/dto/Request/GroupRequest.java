package plasma.swagger.exam.dto.Request;

import lombok.Data;

@Data
public class GroupRequest {

    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}
