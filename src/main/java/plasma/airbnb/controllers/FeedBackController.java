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
        feedBackService.saveFeedback(feedBack);
        return new ResponseEntity<>(HttpStatus.OK);
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

    @PutMapping("/updateFeedback/{id}")
    public ResponseEntity updateFeedBack(@PathVariable("id") Long id, @RequestBody FeedBack feedBack) {
        feedBackService.update(id, feedBack);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/deleteFeedback/{id}")
    public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("id") Long id) {
        if (feedBackService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            feedBackService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
