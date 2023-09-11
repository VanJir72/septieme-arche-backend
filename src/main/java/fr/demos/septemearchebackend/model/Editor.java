package fr.demos.septemearchebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editor")
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editor", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String phoneNumber;
    private String email;
    private String webSite;

    @JsonIgnore
    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<Book>();
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    @OneToMany(mappedBy = "editeur", cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
//    List<Dvd> dvds = new ArrayList<Dvd>();
//    public List<Dvd> getDvds() {
//        return dvds;
//    }
//    public void setDvds(List<Dvd> dvds) {
//        this.dvds = dvds;
//    }



    public Editor() {
    }

    public Editor(String name, String phoneNumber, String email, String webSite, List<Book> books) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.webSite = webSite;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", webSite='" + webSite + '\'' +
                //", books=" + books +
                '}';
    }
}


