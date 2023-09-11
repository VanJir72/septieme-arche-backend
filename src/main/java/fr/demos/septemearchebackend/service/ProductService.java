package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Product;
import fr.demos.septemearchebackend.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product updateProduct(Long id, Product product);

    String deleteProduct(Long id);

    List<Product> getProductByDescription(String description);

    List<Product> getProductByCategory(ProductCategory category);

}


