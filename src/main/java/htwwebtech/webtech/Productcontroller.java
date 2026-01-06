package htwwebtech.webtech;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/products")
@RestController
//empfängt Sachen vom Frontend und schickt Antworten an dieses
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
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        Product savedProduct = productService.save(product);
        return ResponseEntity.status(201).body(savedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.update(id, productDetails);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String name) {
        // Hier rufen wir das Repository/Service auf
        return productService.findByName(name);
    }

    @GetMapping("/filter")
    public List<Product> filterProducts(@RequestParam Double maxPrice) {
        return productService.findByMaxPrice(maxPrice);
    }


        }

