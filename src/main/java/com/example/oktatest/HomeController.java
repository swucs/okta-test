package com.example.oktatest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${okta.oauth2.issuer}")
    private String issuer;

    @Value("${okta.oauth2.client-id}")
    private String clientId;

    @Value("${okta.oauth2.redirect-uri}")
    private String redirectUri;

    @GetMapping(value = "/")
    public String home(Model model, @AuthenticationPrincipal final OidcUser oidcUser) {

        if (oidcUser != null) {

            System.out.println("oidcUser.getAccessTokenHash() = " + oidcUser.getAccessTokenHash());
            System.out.println("oidcUser.getIdToken().getTokenValue() = " + oidcUser.getIdToken().getTokenValue());
            System.out.println("oidcUser.getEmail() = " + oidcUser.getEmail());
            System.out.println("oidcUser.getFullName() = " + oidcUser.getFullName());

            model.addAttribute("accessToken", oidcUser.getAccessTokenHash());
        }
        return "index";
    }
}
