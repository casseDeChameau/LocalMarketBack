package lab.local_market_app.A_Repository;

import lab.local_market_app._Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

//interface extends JpaRepository to get access DB methodes

public interface IProductRepository extends JpaRepository<Product, Long> {

   List<Product> findByNameContaining(String name);

}


