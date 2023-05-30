package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import plasma.airbnb.reposiroty.ImageRepository;

@Controller
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository repository;
}
