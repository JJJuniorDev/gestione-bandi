package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@GetMapping("/me")
	   public ResponseEntity<Map<String, Object>> getUserInfo(Saml2Authentication authentication) {
		if (authentication == null) {
			return null;
		}
        Saml2AuthenticatedPrincipal principal = (Saml2AuthenticatedPrincipal) authentication.getPrincipal();

        Map<String, Object> userData = new HashMap<>();
        userData.put("nome", principal.getFirstAttribute("givenName"));
        userData.put("cognome", principal.getFirstAttribute("sn"));
        userData.put("codiceFiscale", principal.getFirstAttribute("fiscalNumber"));
        userData.put("email", principal.getFirstAttribute("email"));

        return ResponseEntity.ok(userData);
    }
}
