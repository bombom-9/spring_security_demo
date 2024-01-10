//package com.demo.config;
//
//import java.io.File;
//import java.security.cert.X509Certificate;
//
//import org.opensaml.security.x509.X509Support;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.saml2.core.Saml2X509Credential;
//import org.springframework.security.saml2.provider.service.metadata.OpenSamlMetadataResolver;
//import org.springframework.security.saml2.provider.service.registration.InMemoryRelyingPartyRegistrationRepository;
//import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistration;
//import org.springframework.security.saml2.provider.service.registration.RelyingPartyRegistrationRepository;
//import org.springframework.security.saml2.provider.service.web.RelyingPartyRegistrationResolver;
//import org.springframework.security.saml2.provider.service.web.Saml2MetadataFilter;
//import org.springframework.security.saml2.provider.service.web.authentication.Saml2WebSsoAuthenticationFilter;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////	@Autowired
////	RelyingPartyRegistrationResolver relyingPartyRegistrationResolver;
//
////	@Value("${verification.key}")
////	File verificationKey;
////
////	@Bean
////	public RelyingPartyRegistrationRepository relyingPartyRegistrations() throws Exception {
////	    X509Certificate certificate = X509Support.decodeCertificate(this.verificationKey);
////	    Saml2X509Credential credential = Saml2X509Credential.verification(certificate);
////	    RelyingPartyRegistration registration = RelyingPartyRegistration
////	            .withRegistrationId("example")
////	            .assertingPartyDetails(party -> party
////	                .entityId("https://idp.example.com/issuer")
////	                .singleSignOnServiceLocation("https://idp.example.com/SSO.saml2")
////	                .wantAuthnRequestsSigned(false)
////	                .verificationX509Credentials(c -> c.add(credential))
////	            )
////	            .build();
////	    return new InMemoryRelyingPartyRegistrationRepository(registration);
////	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////		Saml2MetadataFilter filter = new Saml2MetadataFilter(relyingPartyRegistrationResolver,
////				new OpenSamlMetadataResolver());
//
//		http.csrf(AbstractHttpConfigurer::disable)
//				.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
//				.saml2Login().and()
//				.saml2Logout().and();
////				.addFilterBefore(filter, Saml2WebSsoAuthenticationFilter.class);
//
//		return http.build();
//
//	}
//
//}
