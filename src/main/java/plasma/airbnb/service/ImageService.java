package plasma.airbnb.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plasma.airbnb.model.Image;
import plasma.airbnb.reposiroty.ImageRepository;
import plasma.airbnb.reposiroty.methods.ImageMethods;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService implements ImageMethods {
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
    @Override
    public String getImage(String imagePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath: " + imagePath);
        byte[] imageBytes = resource.getInputStream().readAllBytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public byte[] getImageBytes(Long imageId) {
        try {
            Image image = service.findById(imageId).orElseThrow(() ->
                    new RuntimeException("Image not found with id: " + imageId));
            return image.getBytes();
        } catch (Exception e) {
            log.error("Error while retrieving image: {}", e.getMessage());
            throw new RuntimeException("Failed to retrieve image", e);
        }
    }

    @Override
    public Image saveImage(byte[] imageBytes) {
        try {
            Image image = new Image();
            image.setBytes(imageBytes);
            return service.save(image);
        } catch (Exception e) {
            log.error("Error while saving image: {}", e.getMessage());
            throw new RuntimeException("Failed to save image", e);
        }
    }

    @Override
    public Image updateImage(Long imageId, byte[] newImageBytes) {
        try {
            Optional<Image> optionalImage = service.findById(imageId);
            if (optionalImage.isPresent()) {
                Image image = optionalImage.get();
                image.setBytes(newImageBytes);
                return service.save(image);
            } else {
                throw new RuntimeException("Image not found with id: " + imageId);
            }
        } catch (Exception e) {
            log.error("Error while updating image: {}", e.getMessage());
            throw new RuntimeException("Failed to update image", e);
        }
    }
    @Override
    public List<Image> findAll() {
        return service.findAll();
    }
}