package lab.local_market_app.security.repository;

import lab.local_market_app.security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
  
}
