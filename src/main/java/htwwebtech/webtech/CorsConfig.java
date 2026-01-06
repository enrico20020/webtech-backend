package htwwebtech.webtech;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Sicherheitsfreigabe, erlaubt Frontend auf Backend zuzugreifen
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings (CorsRegistry registry) {
        // definiert das wo
        registry.addMapping("/**")
                // Verknüpfung Frontend
                .allowedOrigins("https://webtech-frontend-6w6z.onrender.com")
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
