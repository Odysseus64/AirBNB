package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.airbnb.model.Application;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}