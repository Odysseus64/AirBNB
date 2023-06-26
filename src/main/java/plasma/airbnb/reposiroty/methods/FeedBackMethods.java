package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.FeedBack;

import java.util.List;
public interface FeedBackMethods {
    FeedBack saveFeedback(FeedBack feedBack);
    void deleteById(Long id);
    void update(Long id, FeedBack feedback);
    FeedBack findById(Long id);
    List<FeedBack> findAll();
}
