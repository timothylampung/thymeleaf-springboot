package com.internbacked.internbacked.auth.api.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/hello")
@RestController
public class HelloResource {


    @GetMapping("/all")
    public String hello(){
        return "Hello! Everyone!";
    }




    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(){
        return "Hello!Confidential People!";
    }

}
