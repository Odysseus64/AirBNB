package plasma.airbnb.dto.response;

import lombok.Data;
import plasma.airbnb.enums.DecisionStatus;

@Data
public class ApplicationResponse {
    private Long applicationId;

    private DecisionStatus decisionStatus;
    private boolean accepted;
    private String message;
}
