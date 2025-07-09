package com.gestionebandi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {
	@Value("${jwt.secret}")
    private String secret;
	 @Value("${jwt.expiration}")
    private long expirationMs;
	 
	 
	 

    public String getSecret() { 
    	return secret; }
    
    public void setSecret(String secret) { 
    	this.secret = secret; }
    
    public long getExpirationMs() { 
    	return expirationMs; }
    
    public void setExpirationMs(long expirationMs) { 
    	this.expirationMs = expirationMs; }
}
