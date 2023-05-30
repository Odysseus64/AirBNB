package plasma.airbnb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import plasma.airbnb.model.Image;
import plasma.airbnb.reposiroty.ImageRepository;
import plasma.airbnb.reposiroty.methods.ImageMethods;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageMethods {
    public final ImageRepository service;
    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, Image image) {

    }

    @Override
    public Image findById(Long id) {
        return null;
    }

    @Override
    public Image save(Image image) {
        return null;
    }

    @Override
    public List<Image> findAll() {
        return null;
    }
}
