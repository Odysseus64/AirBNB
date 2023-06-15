package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import plasma.airbnb.enums.Region;
import plasma.airbnb.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select s from Product s where s.title = :title ")
    List<Product> findByTitle(@Param("title") String title);

    @Query("select s from Product s where s.price = :price")
    List<Product> findByPrice(@Param("price") String price);

    @Query("select s from Product s where s.region = :region")
    List<Product> findByRegion(@Param("region") String region);

    @Query("select s from Product s where s.type = :type")
    List<Product> findByType(@Param("type") String type);

    @Query("select s from Product s order by s.title desc ")
    List<Product> ratingTitle();

    @Query("select s from Product s order by s.price desc ")
    List<Product> ratingPrice();

    @Query("select s from Product s order by s.region desc ")
    List<Product> ratingRegion();

    @Query("select s from Product s order by s.type desc ")
    List<Product> ratingType();
}
