package lab.local_market_app.A_Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lab.local_market_app._Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.List;


public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameContaining(String username);
    User findByUsername(String username);
    User findUserById(Long id);
}
