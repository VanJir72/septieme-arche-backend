package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAllAuthors();
    Optional<Author> getAuthorById(Long id);
    Author updateAuthor(Long id, Author author);
    String deleteAuthor(Long id);

}
