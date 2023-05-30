package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import plasma.airbnb.reposiroty.FeedBackRepository;

@Controller
@RequiredArgsConstructor
public class FeedBackController {
    private final FeedBackRepository repository;
}
