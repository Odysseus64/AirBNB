package plasma.reposiroty;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.model.Image;

@Repository
public interface ImageSRepository extends JpaRepository<Image, Long> {
}
