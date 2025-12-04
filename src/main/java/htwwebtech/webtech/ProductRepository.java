package htwwebtech.webtech;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// direkte Verbindung zur Datenbank
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
