package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.reposiroty.FeedBackRepository;
import plasma.airbnb.reposiroty.methods.FeedBackMethods;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService implements FeedBackMethods {
    public final FeedBackRepository service;

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, FeedBack feedBack) {

    }

    @Override
    public FeedBack findById(Long id) {
        return null;
    }

    @Override
    public FeedBack save(FeedBack feedBack) {
        return null;
    }

    @Override
    public List<FeedBack> findAll() {
        return null;
    }
}
