package fr.demos.septemearchebackend.service.impl;
;

import fr.demos.septemearchebackend.exceptions.BookNotFoundException;
import fr.demos.septemearchebackend.model.*;
import fr.demos.septemearchebackend.repository.AuthorRepository;
import fr.demos.septemearchebackend.repository.BookRepository;
import fr.demos.septemearchebackend.repository.EditorRepository;
import fr.demos.septemearchebackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final AuthorRepository authorRepository;

    @Autowired
    private final EditorRepository editorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, EditorRepository editorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.editorRepository = editorRepository;
    }



    @Override
    public Book createBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }


    @Override
    public List<Book> createAllBooks(Iterable<Book> livres) {
        return bookRepository.saveAll(livres);
    }


    @Override
    public List<Book> getAllBooks() throws BookNotFoundException {
        List<Book> books = bookRepository.findAll();
        if (books.size() > 0) {
            return books;
        } else {
            throw new BookNotFoundException("Pas de resultat !");
        }
    }


    @Override
    public Optional<Book> getBookById(Long id) throws BookNotFoundException {
        if (bookRepository.findById(id).isPresent()) {
            return bookRepository.findById(id);
        } else {
            throw new BookNotFoundException("Aucun livre a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public Book updateBook(Long id, Book book) throws BookNotFoundException {
        if(bookRepository.findById(id).isPresent()){
            book.setId(id);
            return bookRepository.save(book);
        } else {
            throw new BookNotFoundException("Aucun book a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "OK";
    }








    /*@Override
    public List<Book> getLivresByTitre(String titre) {
        return bookRepository.findByTitreContains(titre.toLowerCase());
    }*/

    /*@Override
    public List<Book> getLivresByNomDeAuteur(String nom) {
        return bookRepository.findByNomDeAuteur(nom);
    }*/
}

