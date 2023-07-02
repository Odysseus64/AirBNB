package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import plasma.airbnb.service.ImageService;

import java.io.IOException;

@Controller
@RestController("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/image")
    public String getImage(@RequestBody String str) throws IOException {
        return imageService.getImage(str);
    }
}
