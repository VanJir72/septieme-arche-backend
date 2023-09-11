package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.exceptions.ProductNotFoundException;
import fr.demos.septemearchebackend.model.Book;
import fr.demos.septemearchebackend.model.Product;
import fr.demos.septemearchebackend.model.ProductCategory;
import fr.demos.septemearchebackend.response.ResponseHandler;
import fr.demos.septemearchebackend.service.BookService;
import fr.demos.septemearchebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final BookService bookService;

    @Autowired
    private final ProductService productService;

    public ProductController(BookService bookService, ProductService productService) {
        this.bookService = bookService;
        this.productService = productService;
    }


    /* ========================================== create: (Products: Book, Dvd, ...etc) =========================================== */
    @PostMapping() //creates only an object (product) with its own attributes.
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
    @PostMapping("createBook") //creates an object (book) with all attributes (book + super() from Class Product).
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }
    @PostMapping("createAllBooks")
    public ResponseEntity<List<Book>> createAllBooks(@RequestBody List<Book> books) {
        List<Book> createdBooks = bookService.createAllBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooks);
    }
    /* ==================================================================================================================== */

    /* ========================================= getAll: (Products: Book, Dvd, ...etc) ========================================== */
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("readAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    /* ==================================================================================================================== */

    /* ========================================= getById: (Products: Book, Dvd, ...etc) ========================================== */
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    /* ==================================================================================================================== */

    /* ======================================== update: (Products: Book, Dvd, ...etc) ========================================= */
    @PutMapping("/{id}") //OK only with products created by API: @PostMapping() = createProduct
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)  {
        return productService.updateProduct(id, product);
    }
    @PutMapping("updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book)  {
        return bookService.updateBook(id, book);
    }
    /* ==================================================================================================================== */

    /* ======================================== delete: (Products: Book, Dvd, ...etc) ========================================= */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        if (productService.getProductById(id).isPresent()){
            return ResponseHandler.responseBuilder("L'article avec l'id = " + id + ", a bien été supprimé.",
                    HttpStatus.OK, productService.deleteProduct(id));
        } else {
            throw new ProductNotFoundException("Aucun article a été trouvé avec l'id = " + id + ".");
        }
    }
    /* ==================================================================================================================== */


    /* ============================================ getProductByDescription ============================================= */
    @GetMapping(params = {"description"})
    public ResponseEntity<List<Product>> getProductByDescription(@RequestParam String description) throws ProductNotFoundException {
        List<Product> products = productService.getProductByDescription(description);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Aucun article est trouvé avec la déscription de : " + description + ".");
        }
        return ResponseEntity.ok(products);
    }
    /* ==================================================================================================================== */


    /* ============================================ getProductByCategory ============================================= */
    @GetMapping(params = {"category"})
    public ResponseEntity<List<Product>> getProductByCategory(@RequestParam ProductCategory category) throws ProductNotFoundException {
        List<Product> products = productService.getProductByCategory(category);
        if (products.isEmpty()) {
            throw new ProductNotFoundException("Aucun article est trouvé avec la categorie de : " + category + ".");
        }
        return ResponseEntity.ok(products);
    }

    /* ==================================================================================================================== */

}

