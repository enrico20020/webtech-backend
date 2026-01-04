package htwwebtech.webtech;

import htwwebtech.webtech.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Datenbankschnittstelle, direkte Funktionen
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     // Use-Case 6: Suche nach Namen (Teilstring, Ignoriert Groß/Kleinschreibung)
        List<Product> findByNameContainingIgnoreCase(String name);

        // Use-Case 7: Preis-Filter (Alles was günstiger ist als...)
        List<Product> findByPriceLessThanEqual(double maxPrice);
    }



