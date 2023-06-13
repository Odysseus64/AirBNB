package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import plasma.airbnb.model.FeedBack;
import plasma.airbnb.service.FeedBackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping("/saveFeedback")
    public String saveFeedBack(@RequestBody FeedBack feedBack) {
        feedBackService.saveFeedback(feedBack);
        return "Comments successfully save";
    }
    @DeleteMapping("deleteFeedback")
    public String deleteFeedBack(@PathVariable Long id){
        feedBackService.deleteById(id);
        return "Comments successfully delete";
    }
    @PutMapping("/updateFeedback/{id}")
    public String updateFeedBack(@PathVariable Long id,@RequestBody FeedBack feedBack){
        feedBackService.update(id,feedBack);
        return "Comments successfully update";
    }
    @GetMapping("/getFeedback{id}")
    public FeedBack findById(@PathVariable("id") Long id){
        return feedBackService.findById(id);
    }
    @GetMapping("/getAllFeedback")
    public List<FeedBack> getAll(){
        return feedBackService.findAll();
    }
}
