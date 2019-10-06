package lab.local_market_app.B_Services;

import lab.local_market_app.A_Repository.IProductRepository;
import lab.local_market_app._Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


// here we implements services interface to override the methods
// and we inject repository interface by declaring it

@Service
public class ProductServices implements IProductServices {

    @Autowired
   private IProductRepository productRepository;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>       CRUD        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//
    //Create >USED
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    //Read (all) >USED
    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    //Read (by name) >NOT USED
    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    //Update >NOT USED
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    //Delete >NOT USED
    @Override
    public void deleteProduct(Long idProduct) {
         productRepository.deleteById(idProduct);
    }



}
