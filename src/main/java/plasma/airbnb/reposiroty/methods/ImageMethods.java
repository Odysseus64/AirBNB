package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.Image;

import java.io.IOException;
import java.util.List;

public interface ImageMethods {
    Image updateImage(Long imageId, byte[] newImageBytes);
    Image saveImage(byte[] imageData);
    List<Image> findAll();
    void deleteById(Long id);
    String getImage(String imagePath) throws IOException;
}
