package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import plasma.airbnb.dto.request.FeedbackRequest;
import plasma.airbnb.dto.response.FeedbackResponse;
import plasma.airbnb.service.FeedBackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping("/saveFeedback")
    public String saveFeedBack(@RequestBody FeedbackRequest feedbackRequest) {
        feedBackService.saveFeedback(feedbackRequest);
        return "Comments successfully save";
    }
    @DeleteMapping("deleteFeedback")
    public String deleteFeedBack(@PathVariable Long id){
        feedBackService.deleteById(id);
        return "Comments successfully delete";
    }
    @PutMapping("/updateFeedback/{id}")
    public String updateFeedBack(@PathVariable Long id,@RequestBody FeedbackRequest feedbackRequest){
        feedBackService.update(id,feedbackRequest);
        return "Comments successfully update";
    }
    @GetMapping("/getFeedback{id}")
    public FeedbackResponse findById(@PathVariable Long id){
        return feedBackService.findById(id);
    }
    @GetMapping("/getAllFeedback")
    public List<FeedbackResponse> getAll(){
        return feedBackService.findAll();
    }
}
