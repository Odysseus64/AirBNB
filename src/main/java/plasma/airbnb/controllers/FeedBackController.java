package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.service.FeedBackService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

/*
    @PostMapping("/saveFeedback")
    public String saveFeedBack(@RequestBody FeedBack feedBack) {
        feedBackService.saveFeedback(feedBack);
        return "Comments successfully save";
    } // Метод должен отправлять HTTP запрос

    @GetMapping("/getAllFeedback")
    public List<FeedBack> getAll(){
        return feedBackService.findAll();
    }

    @GetMapping("/getFeedback{id}")
    public FeedBack findById(@PathVariable("id") Long id){
        return feedBackService.findById(id);
    }

    // Исправите или удалите и напишите код по лучше
    @PutMapping("/updateFeedback/{id}")
    public String updateFeedBack(@PathVariable("id") Long id, @RequestBody FeedBack feedBack){
        feedBackService.update(id,feedBack);
        return "Comments successfully update";
    }
    // Качество. Вот чего я добиваюсь в разработке любого ПО
*/

    // Приблизительно так:
    @DeleteMapping("/deleteFeedback/{id}")
    public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("id") Long id) {
        if (feedBackService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            feedBackService.deleteById(id);// logining
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
