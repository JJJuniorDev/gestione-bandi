package utils;

import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class X509CertificateUtils {
    public static X509Certificate parse(InputStream inputStream) throws Exception {
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) factory.generateCertificate(inputStream);
    }
}
