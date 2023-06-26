package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.service.FeedBackService;

@RequiredArgsConstructor
@RestController("api/v1/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping("/save/FeedBack")
    public ResponseEntity<FeedBack> saveFeedBack(@RequestBody FeedBack feedBack) {
        feedBackService.saveFeedback(feedBack);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/all/FeedBack")
    public ResponseEntity<FeedBack> getAll() {
        feedBackService.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/FeedBack/{id}")
    public ResponseEntity<FeedBack> findById(@PathVariable("id") Long id) {
        feedBackService.findById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateFeedback/{id}")
    public ResponseEntity<FeedBack> updateFeedBack(@PathVariable("id") Long id, @RequestBody FeedBack feedBack) {
        feedBackService.update(id, feedBack);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/FeedBack/{id}")
    public ResponseEntity<FeedBack> deleteFeedBack(@PathVariable("id") Long id) {
        if (feedBackService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            feedBackService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
