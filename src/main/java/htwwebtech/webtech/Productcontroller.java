package htwwebtech.webtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Productcontroller {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello from Spring Boot!"; }
}
