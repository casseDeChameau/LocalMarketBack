package lab.local_market_app.A_Repository;

import lab.local_market_app._Domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISellerRepository extends JpaRepository<Seller, Long> {

    List<Seller> findByShopNameContaining(String shopName);

}
