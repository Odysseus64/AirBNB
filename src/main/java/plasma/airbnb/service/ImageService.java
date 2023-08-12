package plasma.airbnb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plasma.airbnb.model.Image;
import plasma.airbnb.reposiroty.ImageRepository;
import plasma.airbnb.reposiroty.methods.ImageMethods;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService implements ImageMethods {
    // На что он жалуется? нужно исправить.
    @Autowired
    private ImageRepository service;
    private ResourceLoader resourceLoader;

    @Override
    public void deleteById(Long id) {
        try {
            log.info("Deleting image with id: {}", id);
            service.deleteById(id);
        } catch (Exception exception) {
            log.error("Error while deleting image: {}", exception.getMessage());
            throw new RuntimeException("Failed to delete image", exception);
        }
    }
    // Получает по String
    @Override
    public String getImage(String imagePath) throws IOException {

        return Base64.getEncoder().encodeToString(imageBytes);
    }
    @Override
    public Image saveImage(String base64Image) {
        try {
            Image image = new Image();
            image.setName("MyImage");
            image.setUploadDate(new Date());
            image.setImageData(base64Image);
            log.info("Image saved: {}", image);
            return service.save(image);
        } catch (Exception e) {
            log.error("Error uploading image: {}", e.getMessage());
            throw new RuntimeException("Failed to upload image", e);
        }
    }

    @Override
    public Image updateImage(Long imageId, String base64Image) {
        Image image = service.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Image not found with id: " + imageId));
        image.setImageData(base64Image);
        return service.save(image);
    }
    public void findById(Long id){
        service.findById(id);
        log.info("ID: {}", id);
    }
    @Override
    public List<Image> findAll() {
        return service.findAll();
    }
}