package lab.local_market_app._Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "products")
public class Product {

    //++++++++++++++++     VARIABLES   ++++++++++++//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity", precision = 21, scale = 2)
    private BigDecimal quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "photo1")
    public String photo1 = "https://source.unsplash.com/random/600x600/?object";

    @Column(name = "description")
    private String description;

/*    @Column(name = "reserved")
    private boolean reserved = false;*/

    @ManyToOne
    @JsonIgnoreProperties("products")
    private Seller seller;

    //  private IPGeolocationAPI location = new IPGeolocationAPI("d544bf7531624ec8a6f83b130c46ad48");


    //==================    CONSTRUCTOR     ==============//


    public Product() {}

    public Product(String photo1, Long id, String name, BigDecimal quantity, double price, Seller seller){
        this.photo1 = photo1;
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.seller = seller;
    }


    //:::::::::::::::::     SETGET      :::::::::::::::::::://


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }*/

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
