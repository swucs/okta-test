package com.example.oktatest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${auth0.toyota.domain}")
    private String toyotaDomain;

    @Value("${auth0.toyota.client-id}")
    private String toyotaClientId;

    @Value("${auth0.toyota.redirect-uri}")
    private String toyotaRedirectUri;

    @Value("${auth0.lexus.domain}")
    private String lexusDomain;

    @Value("${auth0.lexus.client-id}")
    private String lexusClientId;

    @Value("${auth0.lexus.redirect-uri}")
    private String lexusRedirectUri;



    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("toyotaDomain", toyotaDomain);
        model.addAttribute("toyotaClientId", toyotaClientId);
        model.addAttribute("toyotaRedirectUri", toyotaRedirectUri);
        model.addAttribute("lexusDomain", lexusDomain);
        model.addAttribute("lexusClientId", lexusClientId);
        model.addAttribute("lexusRedirectUri", lexusRedirectUri);

        return "index";
    }
}
