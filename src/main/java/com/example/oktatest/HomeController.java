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


    //prod
    @Value("${auth0.toyota-prod.domain}")
    private String toyotaProdDomain;

    @Value("${auth0.toyota-prod.client-id}")
    private String toyotaProdClientId;

    @Value("${auth0.toyota-prod.redirect-uri}")
    private String toyotaProdRedirectUri;

    @Value("${auth0.toyota-prod.audience}")
    private String toyotaProdAudience;

    @Value("${auth0.lexus-prod.domain}")
    private String lexusProdDomain;

    @Value("${auth0.lexus-prod.client-id}")
    private String lexusProdClientId;

    @Value("${auth0.lexus-prod.redirect-uri}")
    private String lexusProdRedirectUri;

    @Value("${auth0.lexus-prod.audience}")
    private String lexusProdAudience;



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


    @GetMapping(value = "/prod")
    public String prod(Model model) {
        model.addAttribute("toyotaDomain", toyotaProdDomain);
        model.addAttribute("toyotaClientId", toyotaProdClientId);
        model.addAttribute("toyotaRedirectUri", toyotaProdRedirectUri);
        model.addAttribute("toyotaAudience", toyotaProdAudience);
        model.addAttribute("lexusDomain", lexusProdDomain);
        model.addAttribute("lexusClientId", lexusProdClientId);
        model.addAttribute("lexusRedirectUri", lexusProdRedirectUri);
        model.addAttribute("lexusAudience", lexusProdAudience);

        return "prod";
    }
}
