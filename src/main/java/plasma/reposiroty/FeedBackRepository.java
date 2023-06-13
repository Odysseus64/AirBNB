package plasma.reposiroty;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.model.FeedBack;


@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}
