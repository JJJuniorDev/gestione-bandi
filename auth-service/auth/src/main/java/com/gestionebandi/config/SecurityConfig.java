package com.gestionebandi.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.gestionebandi.security.UnauthorizedHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    private final UnauthorizedHandler unauthorizedHandler;
    private static final Logger logger = Logger.getLogger(SecurityConfig.class.getName());
    
    public SecurityConfig(JwtAuthenticationFilter jwtFilter, UnauthorizedHandler unauthorizedHandler) {
        this.jwtFilter = jwtFilter;
        this.unauthorizedHandler = unauthorizedHandler;
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Questo è un messaggio informativo.");
        http.cors(withDefaults()) // va bene così
        .csrf(csrf -> csrf.disable())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(unauthorizedHandler)) 
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/public/**").permitAll() // Queste richieste dovrebbero essere permesse
                            .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
       		.formLogin(form -> form.disable()) // <-- disattiva il redirect automatico su /login
        	.httpBasic(AbstractHttpConfigurer::disable);
        logger.info("ExceptionHandling entryPoint: " + unauthorizedHandler.getClass().getName());


        return http.build();
    }
    




    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // <- NOT the reactive one
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
