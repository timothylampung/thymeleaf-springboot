package com.internbacked.internbacked.auth.api.vo;

import com.internbacked.internbacked.response.domain.model.ResponseImpl;

import java.util.Set;

public class PrincipalVo extends ResponseImpl {

    private Set<RoleVo> authorities;
    private String username, password, contact, email;

    public PrincipalVo(){

    }

    public PrincipalVo(String username, String password, String contact, String email, Set<RoleVo> authorities) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.email = email;
        this.authorities = authorities;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return this.contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setAuthorities(Set<RoleVo> authorities) {
        this.authorities = authorities;
    }

    public Set<RoleVo> getAuthorities() {
        return this.authorities;
    }

    public String getName() {
        return null;
    }
}
