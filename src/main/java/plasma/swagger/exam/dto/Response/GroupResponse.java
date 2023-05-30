package plasma.swagger.exam.dto.Response;

import lombok.Data;

@Data
public class GroupResponse {

    private Long groupId;
    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
}
