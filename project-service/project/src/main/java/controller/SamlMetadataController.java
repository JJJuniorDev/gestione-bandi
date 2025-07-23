package controller;

import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
import org.springframework.security.saml2.provider.service.metadata.OpenSamlMetadataResolver;
import org.springframework.security.saml2.provider.service.metadata.Saml2MetadataResolver;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SamlMetadataController {

    private final RelyingPartyRegistrationRepository relyingPartyRegistrationRepository;
    private final Saml2MetadataResolver metadataResolver;

    public SamlMetadataController(RelyingPartyRegistrationRepository repository) {
        this.relyingPartyRegistrationRepository = repository;
        this.metadataResolver = new OpenSamlMetadataResolver();
    }

    @GetMapping(value = "/saml2/service-provider-metadata/spid", produces = MediaType.APPLICATION_XML_VALUE)
    public String metadata() {
        RelyingPartyRegistration registration = relyingPartyRegistrationRepository.findByRegistrationId("spid");
        return metadataResolver.resolve(registration);
    }
}
