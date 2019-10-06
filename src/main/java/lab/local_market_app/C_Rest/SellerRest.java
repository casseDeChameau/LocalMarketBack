package lab.local_market_app.C_Rest;

import lab.local_market_app.B_Services.ISellerService;
import lab.local_market_app._Domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@CrossOrigin(origins = "*")
public class SellerRest {

    @Autowired
    private ISellerService sellerServices;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Seller addSeller(Seller seller){
        return sellerServices.addSeller(seller);
    }

    @GetMapping
    public List<Seller> findSeller(String name){
        return sellerServices.findSellerByName(name);
    }
    @GetMapping("/all")
    public List<Seller> findAllSeller(){
        return sellerServices.listSeller();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Seller updateSeller(Seller seller){
        return sellerServices.updateSeller(seller);
    }

    @DeleteMapping(path = "/{idSeller}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSeller(@PathVariable Long idSeller){
        sellerServices.deleteSeller(idSeller);
    }

}
