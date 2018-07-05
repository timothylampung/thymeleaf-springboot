package com.internbacked.internbacked.routing;


import com.internbacked.internbacked.auth.domain.dao.UserDao;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetails;
import com.internbacked.internbacked.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/internship")
@Controller
public class AuthRoute {


    private final AuthService authService ;

    @Autowired
    public AuthRoute(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping("/login")
    public String welcome(Map<String, Object> model) {
        model.put("message", "HELLO");
        return "welcome";
    }

    @PreAuthorize("hasAnyRole({'ADMIN'})")
    @RequestMapping("/home")
    public String home(Map<String, Object> model) {
        PrincipalDetails principalDetails = authService.getCurrentLogged();
        model.put("message", principalDetails.getUsername());
        return "home-page";
    }


    @PreAuthorize("hasAnyRole({'ADMIN'})")
    @RequestMapping("/profile")
    public String profile(Map<String, Object> model) {
        model.put("message", authService.getCurrentLogged().getUsername());
        return "profile";
    }


}
