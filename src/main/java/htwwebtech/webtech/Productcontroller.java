package htwwebtech.webtech;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//speichern, Produkte suchen, löschen etc
@RequestMapping("/api/products")
@RestController
// erlaubt Website mit Backend zu kommunizieren
@CrossOrigin
public class Productcontroller {

    private final ProductService productService;

    public Productcontroller(ProductService productService) {
        this.productService = productService;
    }

    // @GetMapping("/sayHello")
    // public String sayHello() {
    //    return "Hello from Spring Boot!"; }


    //REST-Schnittestelle

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.status(201).body(savedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
        }

