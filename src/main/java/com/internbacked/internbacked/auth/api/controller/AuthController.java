package com.internbacked.internbacked.auth.api.controller;


import com.internbacked.internbacked.auth.api.vo.LoginVo;
import com.internbacked.internbacked.auth.domain.dao.UserDao;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetails;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetailsImpl;
import com.internbacked.internbacked.auth.api.vo.PrincipalVo;
import com.internbacked.internbacked.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/api/user")
@RestController
public class AuthController {

    private final
    UserDao userDao;

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService, UserDao userDao) {
        this.authService = authService;
        this.userDao = userDao;
    }


    @GetMapping("/all")
    public String hello(){
        return "Hello! Everyone!";
    }

    @PreAuthorize("hasAnyRole({'ADMIN'})")
    @GetMapping(path = {"/get/details"})
    public PrincipalDetails getDetails(Principal principal){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails principalDetails = userDao.findUserByUsername(auth.getName());
        principalDetails.setAuthorities(auth.getAuthorities());
        return principalDetails;
    }

    @PreAuthorize("hasAnyRole({'ADMIN'})")
    @GetMapping("/get/name")
    public String getName(Principal principal){
        return principal.getName();
    }


    @PostMapping("/login")
    public PrincipalDetails successLogin(@RequestBody LoginVo loginVo){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PrincipalDetails principalDetails = userDao.findUserByUsername(auth.getName());
        principalDetails.setAuthorities(auth.getAuthorities());
        return principalDetails;
    }


    @PostMapping("/register")
    public PrincipalDetails registration(@RequestBody PrincipalVo input){
        return  authService.registerNewUser(input);

    }


}
