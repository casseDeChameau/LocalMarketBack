package lab.local_market_app.B_Services;

//here goes the methodes we need without body

import lab.local_market_app._Domain.Product;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.List;

public interface IProductServices {

    Product addProduct(Product product);
    Product updateProduct(Product product);
    List <Product> listProduct();
    List <Product> findProductByName(String name);
    void deleteProduct(Long idProduct);

}
