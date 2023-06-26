package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.FeedBack;

import java.util.List;
public interface FeedBackMethods {
    FeedBack saveFeedback(FeedBack feedBack);
    void deleteById(Long id);
    void update(Long id, FeedBack feedback);
    FeedBack findById(Long id);
    FeedBack likeFeedBack(Long id);
    FeedBack dislikeFeedBack(Long id);
     double calculateAverageRating(FeedBack feedback);
    List<FeedBack> findAll();
}
