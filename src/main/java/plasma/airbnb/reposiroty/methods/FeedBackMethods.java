package plasma.reposiroty.methods;

import plasma.airbnb.dto.request.FeedbackRequest;
import plasma.airbnb.dto.response.FeedbackResponse;


import java.util.List;

public interface FeedBackMethods {
    void deleteById(Long id);
    FeedbackResponse update(Long id, FeedbackRequest feedbackRequest);
    FeedbackResponse findById(Long id);
    FeedbackResponse saveFeedback(FeedbackRequest feedBackRequest);
    List<FeedbackResponse> findAll();
}
