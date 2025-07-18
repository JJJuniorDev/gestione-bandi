package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")               // tutte le rotte API
                        .allowedOrigins("http://localhost:4200")  // l’URL del tuo front-end Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // metodi permessi
                        .allowedHeaders("*")           // tutti gli header, inclusi Authorization
                        .allowCredentials(true);       // abilita invio cookie e header Authorization
            }
        };
    }
}
