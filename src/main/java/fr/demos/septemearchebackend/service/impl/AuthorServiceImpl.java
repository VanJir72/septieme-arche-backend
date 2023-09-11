package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.AuthorNotFoundException;
import fr.demos.septemearchebackend.model.Author;
import fr.demos.septemearchebackend.repository.AuthorRepository;
import fr.demos.septemearchebackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() throws AuthorNotFoundException {
        List<Author> authors = authorRepository.findAll();
        if (authors.size() > 0) {
            return authors;
        } else {
            throw new AuthorNotFoundException("Pas de resultat !");
        }
    }

    @Override
    public Optional<Author> getAuthorById(Long id) throws AuthorNotFoundException {
        if (authorRepository.findById(id).isPresent()) {
            return authorRepository.findById(id);
        } else {
            throw new AuthorNotFoundException("Aucun auteur a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public Author updateAuthor(Long id, Author author) throws AuthorNotFoundException {
        if (authorRepository.findById(id).isPresent()) {
            author.setId(id);
            return authorRepository.save(author);
        } else {
            throw new AuthorNotFoundException("Aucun author a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public String deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return "OK";
    }
}
