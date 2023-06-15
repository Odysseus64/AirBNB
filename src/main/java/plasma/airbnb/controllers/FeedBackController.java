package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.service.FeedBackService;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feedbacks")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping("/saveFeedback")
    public ResponseEntity saveFeedBack(@RequestBody FeedBack feedBack) {
        if (feedBack.getClass() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            feedBackService.saveFeedback(feedBack);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/getAllFeedback")
    public ResponseEntity<FeedBack> getAll() {
        feedBackService.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getFeedback{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        feedBackService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Исправите или удалите и напишите код по лучше
    @PutMapping("/updateFeedback/{id}")
    public ResponseEntity updateFeedBack(@PathVariable("id") Long id, @RequestBody FeedBack feedBack) {
        feedBackService.update(id, feedBack);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    // Качество. Вот чего я добиваюсь в разработке любого ПО

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
