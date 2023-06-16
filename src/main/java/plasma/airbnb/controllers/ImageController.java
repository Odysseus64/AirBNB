package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.service.ImageService;

@Controller
@RestController("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService service;

}
