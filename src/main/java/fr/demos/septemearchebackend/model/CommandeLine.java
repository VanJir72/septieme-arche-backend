package fr.demos.septemearchebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name = "commande_line")
public class CommandeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande_line", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "commande_id")
    private Commande commande;



    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;


    public CommandeLine() {
    }


    public CommandeLine(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CommandeLine{" +
                "id=" + id +
                ", commande=" + commande +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}


