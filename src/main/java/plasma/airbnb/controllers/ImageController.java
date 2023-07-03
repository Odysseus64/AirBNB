package plasma.airbnb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import plasma.airbnb.service.ImageService;

import java.io.IOException;
import java.util.Base64;

@Controller
@RestController("/api/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload-image")
    public String handleImageUpload(@RequestParam("image") MultipartFile file) {
        try {
            byte[] imageData = file.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(imageData);
            // Сохраняем строку Base64 в базу данных или куда-то еще
            // ...

            return "Image uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading image: " + e.getMessage();
        }
    }
}
