package plasma.airbnb.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import plasma.airbnb.dto.request.FeedbackRequest;
import plasma.airbnb.model.FeedBack;

@Component
@RequiredArgsConstructor
public class FeedbackMapper {

    public FeedBack toFeedback(FeedbackRequest feedbackRequest) {
        return FeedBack.builder()
                .feedBack(feedbackRequest.getFeedback())
                .build();

    }
}

