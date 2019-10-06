package lab.local_market_app._Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sellers")
public class Seller {

//:::::::::::::::::::::::::::       VARIABLES       :::::::::::::::::::::::::::://

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "lat", precision = 21, scale = 2)
    private BigDecimal lat;

    @Column(name = "lng", precision = 21, scale = 2)
    private BigDecimal lng;

    @Column(name = "url_photo")
    private String urlPhoto;

    @OneToMany(mappedBy = "seller")
    private Set<Product>products = new HashSet<>();

//===========================      CONTRUCTOR      =============================//

    public Seller(){

    }

    public Seller(Long id, String shopName, BigDecimal lat, BigDecimal longitude, String urlPhoto){
        this.id=id;
        this.shopName=shopName;
        this.lat =lat;
        this.lng =longitude;
        this.urlPhoto=urlPhoto;
    }

//+++++++++++++++++++++++++++++       GETSET      +++++++++++++++++++++++++++++//


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getLat() {
        return lat;
    }
    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }
    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
