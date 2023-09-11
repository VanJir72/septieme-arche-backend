package fr.demos.septemearchebackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
@PrimaryKeyJoinColumn(name="product_id")
public class Book extends Product {

    private String isbn13;
    private String bookTitle;
    private String kind;
    private String format;
    private int numberOfPages;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "editor_id")
    private Editor editor;


//    @Enumerated(value = EnumType.STRING)
//    private List<Kind> kind;

//    @Enumerated(value = EnumType.STRING)
//    private Format format;


    public Book() {
    }

    public Book(String description, String image, String summary, double exclTaxPrice, double vat, Integer stock, Integer orderedQuantity, ProductCategory category,
                String isbn13, String bookTitle, String kind, String format, int numberOfPages, Author author, Editor editor) {
        super(description, image, summary, exclTaxPrice, vat, stock, category);
        this.isbn13 = isbn13;
        this.bookTitle = bookTitle;
        this.kind = kind;
        this.format = format;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.editor = editor;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", kind='" + kind + '\'' +
                ", format='" + format + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author=" + author +
                ", editor=" + editor +
                '}';
    }
}