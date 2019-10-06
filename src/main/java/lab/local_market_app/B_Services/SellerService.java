package lab.local_market_app.B_Services;

import lab.local_market_app.A_Repository.ISellerRepository;
import lab.local_market_app._Domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService implements ISellerService {


    @Autowired
    private ISellerRepository sellerRepository;

    @Override
    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public List<Seller> listSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public List<Seller> findSellerByName(String shopName) {
        return sellerRepository.findByShopNameContaining(shopName);
    }

    @Override
    public void deleteSeller(Long idSeller) {
        sellerRepository.deleteById(idSeller);
    }
}
