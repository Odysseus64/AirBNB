package plasma.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
