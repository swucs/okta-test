package com.example.oktatest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public String saml(@AuthenticationPrincipal final OidcUser oidcUser) {
        System.out.println("oidcUser.getAccessTokenHash() = " + oidcUser.getAccessTokenHash());
        System.out.println("oidcUser.getIdToken().getTokenValue() = " + oidcUser.getIdToken().getTokenValue());
        System.out.println("oidcUser.getEmail() = " + oidcUser.getEmail());
        System.out.println("oidcUser.getFullName() = " + oidcUser.getFullName());
        return oidcUser.getIdToken().getTokenValue();
    }
}
