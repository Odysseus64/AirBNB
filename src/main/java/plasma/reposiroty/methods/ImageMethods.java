package plasma.reposiroty.methods;


import plasma.model.Image;

import java.util.List;

public interface ImageMethods {
    Image updateImage(Long imageId, byte[] newImageBytes);
    Image saveImage(byte[] imageBytes);
    byte[] getImageBytes(Long imageId);
    List<Image> findAll();
    void deleteById(Long id);
}
