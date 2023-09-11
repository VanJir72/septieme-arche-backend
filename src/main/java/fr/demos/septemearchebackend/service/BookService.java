package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);

    List<Book> createAllBooks(Iterable<Book> books);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book updateBook(Long id, Book book);

    String deleteBook(Long id);


    //List<Book> getBooksByTitle(String title);
    //List<Book> getBooksByNameOfAuthor(String name);


}

