package plasma.airbnb.reposiroty.methods;

import plasma.airbnb.model.Image;

import java.util.List;

public interface ImageMethods {
    void deleteById(Long id);
    void update(Long id, Image image);
    Image findById(Long id);
    Image save(Image image);
    List<Image> findAll();
}
