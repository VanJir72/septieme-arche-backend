package fr.demos.septemearchebackend.repository;


import fr.demos.septemearchebackend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*public interface BookRepository extends ProductRepository{
}*/


public interface BookRepository extends JpaRepository<Book, Long> {

    //List<Book> findByTitreContains(String titre);

   /* List<Book> findByNomDeAuteur(String nom);*/
}




