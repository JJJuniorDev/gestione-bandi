package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.saml2.core.Saml2X509Credential;
import org.springframework.security.saml2.provider.service.registration.*;

import utils.PrivateKeyUtils;
import utils.X509CertificateUtils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

@Configuration
public class SamlRelyingPartyConfig {

 /*   @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() throws Exception {
        X509Certificate certificate = X509CertificateUtils.parse(new ClassPathResource("spid-cert.crt").getInputStream());
        PrivateKey privateKey = PrivateKeyUtils.parse(new ClassPathResource("spid-private.key").getInputStream());

        RelyingPartyRegistration registration = RelyingPartyRegistration
            .withRegistrationId("spid")
            .entityId("https://e64043bae0da.ngrok-free.app/saml2/spid")
            .assertionConsumerServiceLocation("https://e64043bae0da.ngrok-free.app/login/saml2/sso/spid")
            .signingX509Credentials(creds -> creds.add(Saml2X509Credential.signing(privateKey, certificate)))
            .assertingPartyDetails(party -> party
                .entityId("https://identity.infocert.it") // o quello del tuo IdP SPID
                .singleSignOnServiceLocation("https://identity.infocert.it/sso") // o url SSO corretto
                .singleSignOnServiceBinding(Saml2MessageBinding.REDIRECT)
                .verificationX509Credentials(creds -> creds.add(Saml2X509Credential.verification(certificate)))
                .wantAuthnRequestsSigned(true)
            )
            .build();

        return new InMemoryRelyingPartyRegistrationRepository(registration);
    }*/
}
