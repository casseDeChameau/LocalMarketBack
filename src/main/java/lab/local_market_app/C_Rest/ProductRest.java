package lab.local_market_app.C_Rest;

//here, first we put annotation RestControler (endpoint) and RequestMapping(taking request)
//then we inject the services interface by declaring it, we add the "autowired" annotation to makes everything automatic (magic)
//at last we define the "Post" and "Get" Mapping

import lab.local_market_app.B_Services.IProductServices;
import lab.local_market_app._Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductRest {

    @Autowired
    private IProductServices productServices;

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>      CRUD        <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<//

    //create √
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product addProduct(@RequestBody Product product){
        return productServices.addProduct(product);
    }
    //update
    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@RequestBody Product product){
        return productServices.updateProduct(product);
    }
    //read (one by name)
    @GetMapping(path = "/{name}")
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public ResponseEntity<List<Product>>findProductByName(@PathVariable(value = "name") String name) {
        return new ResponseEntity<>(productServices.findProductByName(name), HttpStatus.OK);
    }  // ResponseEntity ne doit être QUE au niveau du REST | il englobe le type : ResponseEntity < List < type > > nom(); | il sert à la sémantique > + d'info du status
    //read (all) √
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public ResponseEntity<List<Product>> listProduct(){
        return new ResponseEntity<>(productServices.listProduct(), HttpStatus.OK);
    }
    //delete
    @DeleteMapping(path = "/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long idProduct){
        productServices.deleteProduct(idProduct);
    }

}
