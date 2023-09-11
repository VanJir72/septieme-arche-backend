package fr.demos.septemearchebackend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String commandeRef;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_At", nullable = false, updatable = false)
    private Date createdAt;
    @PrePersist
    private void onCreate() {createdAt  = new Date();}


    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    private double totalExclTaxPrice;
    private double vat = 0.2;
    private  double totalInclTaxPrice;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "commande", fetch=FetchType.EAGER)
    private List<CommandeLine> commandeLines = new ArrayList<>();




    @OneToOne(mappedBy = "commande", cascade = CascadeType.ALL)
    private Invoice invoice;


    public Commande() {
    }

    public Commande(String commandeRef, Date createdAt, User user, double totalExclTaxPrice, double vat,
                    double totalInclTaxPrice, List<CommandeLine> commandeLines, Invoice invoice) {
        this.commandeRef = commandeRef;
        this.createdAt = createdAt;
        this.user = user;
        this.totalExclTaxPrice = totalExclTaxPrice;
        this.vat = vat;
        this.totalInclTaxPrice = totalInclTaxPrice;
        this.commandeLines = commandeLines;
        this.invoice = invoice;
    }

    public String getCommandeRef() {
        return commandeRef;
    }

    public void setCommandeRef(String commandeRef) {
        this.commandeRef = commandeRef;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalExclTaxPrice() {
        return totalExclTaxPrice;
    }

    public void setTotalExclTaxPrice(double totalExclTaxPrice) {
        this.totalExclTaxPrice = totalExclTaxPrice;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public List<CommandeLine> getCommandeLines() {
        return commandeLines;
    }

    public void setCommandeLines(List<CommandeLine> commandeLines) {
        this.commandeLines = commandeLines;
    }

    public double getTotalInclTaxPrice() {
        return this.totalExclTaxPrice * (1 + this.vat);
    }

    public void setTotalInclTaxPrice(double totalInclTaxPrice) {
        this.totalInclTaxPrice = totalInclTaxPrice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", commandeRef='" + commandeRef + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", totalExclTaxPrice=" + totalExclTaxPrice +
                ", vat=" + vat +
                ", totalInclTaxPrice=" + totalInclTaxPrice +
                //", commandeLines=" + commandeLines +
                ", invoice=" + invoice +
                '}';
    }

}