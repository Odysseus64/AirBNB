package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.airbnb.enums.Region;
import plasma.airbnb.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Region> sortRole(Region region);
}
