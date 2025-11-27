package htwwebtech.webtech;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Standardkonfiguration von Spring Web MVC anzupassen, zu erweitern
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        // definiert das wo
        registry.addMapping("/**")
                // Verknüpfung Frontend
                .allowedOrigins("https://*.onrender.com")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
