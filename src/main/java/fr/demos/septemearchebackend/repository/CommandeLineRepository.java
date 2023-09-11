package fr.demos.septemearchebackend.repository;

import fr.demos.septemearchebackend.model.CommandeLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeLineRepository extends JpaRepository<CommandeLine, Long> {
}
