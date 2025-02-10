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

    @Value("${auth0.toyota.audience}")
    private String toyotaAudience;

    @Value("${auth0.lexus.domain}")
    private String lexusDomain;

    @Value("${auth0.lexus.client-id}")
    private String lexusClientId;

    @Value("${auth0.lexus.redirect-uri}")
    private String lexusRedirectUri;

    @Value("${auth0.lexus.audience}")
    private String lexusAudience;


    //stg
    @Value("${auth0.toyota-stg.domain}")
    private String toyotaStgDomain;

    @Value("${auth0.toyota-stg.client-id}")
    private String toyotaStgClientId;

    @Value("${auth0.toyota-stg.redirect-uri}")
    private String toyotaStgRedirectUri;

    @Value("${auth0.toyota-stg.audience}")
    private String toyotaStgAudience;

    @Value("${auth0.lexus-stg.domain}")
    private String lexusStgDomain;

    @Value("${auth0.lexus-stg.client-id}")
    private String lexusStgClientId;

    @Value("${auth0.lexus-stg.redirect-uri}")
    private String lexusStgRedirectUri;

    @Value("${auth0.lexus-stg.audience}")
    private String lexusStgAudience;



    @GetMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("toyotaDomain", toyotaDomain);
        model.addAttribute("toyotaClientId", toyotaClientId);
        model.addAttribute("toyotaRedirectUri", toyotaRedirectUri);
        model.addAttribute("toyotaAudience", toyotaAudience);
        model.addAttribute("lexusDomain", lexusDomain);
        model.addAttribute("lexusClientId", lexusClientId);
        model.addAttribute("lexusRedirectUri", lexusRedirectUri);
        model.addAttribute("lexusAudience", lexusAudience);

        return "index";
    }



    @GetMapping(value = "/stg")
    public String stg(Model model) {
        model.addAttribute("toyotaDomain", toyotaStgDomain);
        model.addAttribute("toyotaClientId", toyotaStgClientId);
        model.addAttribute("toyotaRedirectUri", toyotaStgRedirectUri);
        model.addAttribute("toyotaAudience", toyotaStgAudience);
        model.addAttribute("lexusDomain", lexusStgDomain);
        model.addAttribute("lexusClientId", lexusStgClientId);
        model.addAttribute("lexusRedirectUri", lexusStgRedirectUri);
        model.addAttribute("lexusAudience", lexusStgAudience);

        return "stg";
    }
}
