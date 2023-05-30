package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.airbnb.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
