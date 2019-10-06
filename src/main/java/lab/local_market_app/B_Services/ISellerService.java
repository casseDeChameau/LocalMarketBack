package lab.local_market_app.B_Services;

import lab.local_market_app._Domain.Seller;

import java.util.List;

public interface ISellerService {

    Seller addSeller(Seller seller);
    Seller updateSeller(Seller seller);
    List<Seller> listSeller();
    List <Seller> findSellerByName(String name);
    void deleteSeller(Long idSeller);

}
