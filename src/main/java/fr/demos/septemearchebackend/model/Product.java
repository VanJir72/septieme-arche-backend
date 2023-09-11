package fr.demos.septemearchebackend.model;


import fr.demos.septemearchebackend.exceptions.StockException;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    private String description;
    private String image;
    private String summary;
    private double exclTaxPrice;
    private double vat = 0.2;
    private Integer stock;


    @Enumerated(value = EnumType.STRING)
    private ProductCategory category;


    public Product() {
    }

    public Product(String description, String image, String summary, double exclTaxPrice, double vat,
                   Integer stock, ProductCategory category) {
        this.description = description;
        this.image = image;
        this.summary = summary;
        this.exclTaxPrice = exclTaxPrice;
        this.vat = vat;
        this.stock = stock;
        this.category = category;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getExclTaxPrice() {
        return exclTaxPrice;
    }

    public void setExclTaxPrice(double exclTaxPrice) {
        this.exclTaxPrice = exclTaxPrice;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public boolean isDigitalProduct() {
        return (this.stock == null) ? true : false;
    }

    public double getInclTaxPrice() {
        return this.exclTaxPrice * (1 + this.vat);
    }




    public void incrementStock(Integer addition) {
        this.stock += addition;
    }

//    public void decrementStock(Integer orderedQuantity) throws StockException {    //withDrawal
//        if (this.getOrderedQuantity() <= this.stock) {
//            this.stock -= this.getOrderedQuantity();
//        } else {
//            throw new StockException("Stock Insuffisant !");
//        }
//    }

    public void decrementStock(Integer withDrawal) throws StockException {    //withDrawal
        if (withDrawal <= this.stock) {
            this.stock -= withDrawal;
        } else {
            throw new StockException("Stock Insuffisant !");
        }
    }


    public Integer getStock() {
        return stock;
    }

     /*  public void setStock(Integer stock) {
        this.stock = stock;
    }*/





    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", summary='" + summary + '\'' +
                ", exclTaxPrice=" + exclTaxPrice +
                ", vat=" + vat +
                ", stock=" + stock +
                ", category=" + category +
                ", isDigitalProduct=" + this.isDigitalProduct() +
                ", inclTaxPrice=" + this.getInclTaxPrice() +
                '}';
    }
}





