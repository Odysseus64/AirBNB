package plasma.airbnb.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plasma.airbnb.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
