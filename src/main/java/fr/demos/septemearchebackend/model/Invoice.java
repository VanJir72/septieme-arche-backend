package fr.demos.septemearchebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    private String invoiceRef;


    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "commande_id")
    private Commande commande;



    public Invoice() {
    }

    public Invoice(String invoiceRef, Commande commande) {
        this.invoiceRef = invoiceRef;
        this.commande = commande;
    }



    public String getInvoiceRef() {
        return invoiceRef;
    }

    public void setInvoiceRef(String invoiceRef) {
        this.invoiceRef = invoiceRef;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceRef='" + invoiceRef + '\'' +
                ", commande=" + commande +
                '}';
    }
}