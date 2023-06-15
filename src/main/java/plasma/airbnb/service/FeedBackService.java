package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import plasma.model.FeedBack;
import plasma.reposiroty.FeedBackRepository;
import plasma.reposiroty.methods.FeedBackMethods;
=======
import plasma.airbnb.dto.request.FeedbackRequest;
import plasma.airbnb.dto.response.FeedbackResponse;
import plasma.airbnb.exception.CustomRuntimeException;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.reposiroty.FeedBackRepository;
import plasma.airbnb.reposiroty.methods.FeedBackMethods;
>>>>>>> 988e34fd357c2519e6d187c27d147997de78064a

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedBackService implements FeedBackMethods {
<<<<<<< HEAD
    public final FeedBackRepository service;
=======
    private final FeedBackRepository feedBackRepository;
    private final ModelMapper modelMapper;

    @Override
    public FeedbackResponse saveFeedback(FeedbackRequest feedBackRequest) {
        FeedBack feedBack = modelMapper.map(feedBackRequest, FeedBack.class);
        feedBack = feedBackRepository.save(feedBack);
        try {
            log.info("Saving feedback: {}", feedBackRequest);
            return modelMapper.map(feedBack, FeedbackResponse.class);
        } catch (Exception exception) {
            log.error("Error while saving feedback: {}", exception.getMessage());
            throw new RuntimeException("Failed to save feedback", exception);
        }
    }
>>>>>>> 988e34fd357c2519e6d187c27d147997de78064a

    @Override
    public void deleteById(Long id) {
        boolean exists = feedBackRepository.existsById(id);
        try {
            log.info("Deleting feedback with id: {}", id);
            feedBackRepository.deleteById(id);
        } catch (Exception exception) {
            log.error("Error while deleting feedback: {}", exception.getMessage());
            if (exists) {
                throw new RuntimeException("Failed to delete feedback" + exception);
            }
        }
    }

    @Override
    public FeedbackResponse update(Long id, FeedbackRequest feedbackRequest) {
        FeedBack feedBack = feedBackRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Course not found with!" + id));
        modelMapper.map(feedbackRequest, feedBack);
        feedBack = feedBackRepository.save(feedBack);
        try {
            FeedBack feedBack1 = feedBackRepository.findById(id).orElseThrow();
            feedBack1.setImages(feedBack.getImages());
            feedBack1.setProduct(feedBack.getProduct());
            feedBack1.setFeedBack(feedBack1.getFeedBack());
            feedBackRepository.save(feedBack1);
            log.info("FeedBack updated: {}", feedBack1);
            log.info("Feedback finding with id: {}", id);
        } catch (Exception exception) {
            log.error("Error while updating feedback: {}", exception.getMessage());
            throw new RuntimeException("FeedBack not found with id: {}" + exception);
        }
        return modelMapper.map(feedBack, FeedbackResponse.class);
    }

    @Override
    public FeedbackResponse findById(Long id) {
        FeedBack feedBack = feedBackRepository.findById(id)
                .orElseThrow(() -> new CustomRuntimeException("Feedback not found with id "+id));
        try {
            log.info("Finding FeedBack with id: {}", id);
            return modelMapper.map(feedBack, FeedbackResponse.class);
        } catch (Exception exception) {
            log.error("Error while finding feedback: {}", exception.getMessage());
            throw new RuntimeException("Failed to find feedback", exception);
        }
    }

    @Override
<<<<<<< HEAD
    public FeedBack save(FeedBack feedBack) {
        try {
            log.info("Saving feedback: {}", feedBack);
            return service.save(feedBack);
        } catch (Exception exception) {
            log.error("Error while saving feedback: {}", exception.getMessage());
            throw new RuntimeException("Failed to save feedback", exception);
        }
    }

    @Override
    public List<FeedBack> findAll() {
        return service.findAll();
=======
    public List<FeedbackResponse> findAll() {
        List<FeedBack> feedBackList = feedBackRepository.findAll();
        return feedBackList.stream()
                .map(feedBack -> modelMapper.map(feedBack, FeedbackResponse.class))
                .collect(Collectors.toList());
>>>>>>> 988e34fd357c2519e6d187c27d147997de78064a
    }
}
