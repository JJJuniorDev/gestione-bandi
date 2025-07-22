package com.gestionebandi.security;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint {
	
	private static final Logger logger = Logger.getLogger(UnauthorizedHandler.class.getName());
    
	@Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         org.springframework.security.core.AuthenticationException authException) throws IOException {
    	logger.info("UnauthorizedHandler triggered for path: " + request.getRequestURI());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token non valido o mancante");
    }
}