package fr.demos.septemearchebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author", nullable = false)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    private String lastName;
    private String firstName;


    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<Book>();
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval = true)
//    List<Dvd> dvds = new ArrayList<Dvd>();
//    public List<Dvd> getDvds() {
//        return dvds;
//    }
//    public void setDvds(List<Dvd> dvds) {
//        this.dvds = dvds;
//    }


    public Author() {
    }

    public Author(String lastName, String firstName, List<Book> books) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.books = books;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                //", books=" + books +
                '}';
    }
}