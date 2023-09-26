package fr.demos.septemearchebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Enumerated(value = EnumType.STRING)
    private AdresseType addressType; //Think to change it to List<AddressType>
    private String addressDetails;
    private String city;
    private String postalCode;
    private String country;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;





    public Address() {
    }

    public Address(AdresseType addressType, String addressDetails, String city, String postalCode, String country, User user) {
        this.addressType = addressType;
        this.addressDetails = addressDetails;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.user = user;
    }

    public AdresseType getAddressType() {
        return addressType;
    }

    public void setAddressType(AdresseType addressType) {
        this.addressType = addressType;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressType=" + addressType +
                ", addressDetails='" + addressDetails + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                //", user=" + user +
                '}';
    }


}