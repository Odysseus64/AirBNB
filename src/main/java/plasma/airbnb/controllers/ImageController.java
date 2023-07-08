package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import plasma.airbnb.service.ImageService;

import java.io.IOException;

@Controller
@RestController("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload-image")
    public String handleImageUpload(@RequestParam("image") MultipartFile file) {
        try {
            // Выйдет ошибкy потому что картинку мы дает в String а как в byte я хз
            byte[] imageData = file.getBytes();
            imageService.saveImage(imageData);
            return "Image uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading image: " + e.getMessage();
        }
    }
}
