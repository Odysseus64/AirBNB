package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import plasma.airbnb.model.FeedBack;
import plasma.airbnb.service.FeedBackService;

import java.util.List;

@RequiredArgsConstructor
@RestController("/api/v1/feedback")
public class FeedBackController {

    private final FeedBackService feedBackService;

    @PostMapping("/save/feedback")
    public ResponseEntity<FeedBack> saveFeedBack(@RequestBody FeedBack feedBack) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(feedBackService.saveFeedback(feedBack));
    }

    @GetMapping("/get/all/feedback")
    public ResponseEntity<List<FeedBack>> getAll() {
        feedBackService.findAll();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(feedBackService.findAll());
    }

    @GetMapping("/get/feedback/{id}")
    public ResponseEntity<FeedBack> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(feedBackService.findById(id));
    }

    @PutMapping("/update/feedback/{id}")
    public ResponseEntity updateFeedBack(@PathVariable("id") Long id, @RequestBody FeedBack feedBack) {
        feedBackService.update(id, feedBack);
        return new ResponseEntity(HttpStatus.OK);
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
    @PostMapping("/{id}/like")
    public FeedBack likeFeedback(@PathVariable("id") Long id) {
        return feedBackService.likeFeedBack(id);
    }

    @PostMapping("/{id}/dislike")
    public FeedBack dislikeFeedback(@PathVariable("id") Long id) {
        return feedBackService.dislikeFeedBack(id);
    }

    @GetMapping("/{id}/average-rating")
    public double getAverageRating(@PathVariable("id") Long id) {
        FeedBack feedBack = feedBackService.findById(id);
        return feedBackService.calculateAverageRating(feedBack);
    }

}
