package fr.demos.septemearchebackend.controller;



import fr.demos.septemearchebackend.exceptions.AuthorNotFoundException;
import fr.demos.septemearchebackend.model.Author;
import fr.demos.septemearchebackend.response.ResponseHandler;
import fr.demos.septemearchebackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }



    /* ================================================== createAuteur =================================================== */
    @PostMapping()
    public ResponseEntity<Author> createAuteur(@RequestBody Author author) {
        Author createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }
    /* ==================================================================================================================== */

    /* ================================================== getAllAuteurs =================================================== */
    @GetMapping()
    public List<Author> getAllAuteur() {
        return authorService.getAllAuthors();
    }
    /* ==================================================================================================================== */

    /* ================================================== getAuteurById =================================================== */
    @GetMapping("/{id}")
    public Optional<Author> getAuteurById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }
    /* ==================================================================================================================== */

    /* ================================================== updateAuteur =================================================== */
    @PutMapping("/{id}")
    public Author updateAuteur(@PathVariable Long id, @RequestBody Author author)  {
        return authorService.updateAuthor(id, author);
    }
    /* ==================================================================================================================== */

    /* ================================================== deleteAuteur =================================================== */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuteur(@PathVariable Long id) throws AuthorNotFoundException {
        if (authorService.getAuthorById(id).isPresent()) {
            return ResponseHandler.responseBuilder("L'auteur avec l'id = " + id + ", a bien été supprimé.",
                    HttpStatus.OK, authorService.deleteAuthor(id));
        } else {
            throw new AuthorNotFoundException("Aucun auteur a été trouvé avec l'id = " + id + ".");
        }
    }
    /* ==================================================================================================================== */
}
