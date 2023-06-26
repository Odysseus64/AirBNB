package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import plasma.airbnb.model.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    @Query("SELECT AVG(f.rating) FROM FeedBack f")
    double calculateAverageRating(FeedBack feedback);
}
