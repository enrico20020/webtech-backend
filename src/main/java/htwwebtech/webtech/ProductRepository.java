package htwwebtech.webtech;

import htwwebtech.webtech.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Datenbankschnittstelle, direkte Funktionen
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     // Use-Case 6: Suche nach Namen
        List<Product> findByNameContainingIgnoreCase(String name);

        // Use-Case 7: Preis-Filter
        List<Product> findByPriceLessThanEqual(double maxPrice);
    }



