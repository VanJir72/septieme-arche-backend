package fr.demos.septemearchebackend.repository;

import fr.demos.septemearchebackend.model.Product;
import fr.demos.septemearchebackend.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDescriptionContains(String description);





    /*@Query("SELECT a FROM Product a WHERE a.prixHT > ?1 and a.prixHT < ?2")
    List<Product> findAllBetweenPrix(double prixMin, double prixMax);*/


}
