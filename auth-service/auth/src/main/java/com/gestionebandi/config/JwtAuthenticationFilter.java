package com.gestionebandi.config;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.jwt.token.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final JwtUtil jwtUtil;
	private static final Logger logger = Logger.getLogger(JwtAuthenticationFilter.class.getName());

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("JwtAuthenticationFilter invoked on: " + request.getRequestURI());

		
		 String path = request.getRequestURI();
		    if (path.startsWith("/public/")) {
		        filterChain.doFilter(request, response);
		        return;
		    }
		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {
			String token = header.substring(7);
			 logger.info("JWT estratto: " + token);
			if (jwtUtil.validateToken(token)) {
				 logger.info("Token valido.");
				String username = jwtUtil.getUsernameFromToken(token);

				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
						null);

				auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(auth);
			}else {
				logger.warning("TOKEN NON VALIDO");
			}
		}

		filterChain.doFilter(request, response);
	}
}
