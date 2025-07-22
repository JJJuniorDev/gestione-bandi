package com.gestionebandi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.jwt.token.JwtUtil;

@Component
public class JwtProperties {
	@Value("${jwt.secret}")
    private String secret;
	 @Value("${jwt.expiration}")
    private long expirationMs;
	 
	 @Bean
	 public JwtUtil jwtUtil() {
	 return new JwtUtil(secret, expirationMs);
	 }
	 

    public String getSecret() { 
    	return secret; }
    
    public void setSecret(String secret) { 
    	this.secret = secret; }
    
    public long getExpirationMs() { 
    	return expirationMs; }
    
    public void setExpirationMs(long expirationMs) { 
    	this.expirationMs = expirationMs; }
}
