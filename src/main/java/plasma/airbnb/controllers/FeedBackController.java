package plasma.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import plasma.reposiroty.FeedBackRepository;

@RestController
@RequiredArgsConstructor
public class FeedBackController {
    private final FeedBackRepository repository;
}
