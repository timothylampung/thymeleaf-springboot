package com.internbacked.internbacked.auth.domain.model;

import com.internbacked.internbacked.response.domain.model.Response;
import com.internbacked.internbacked.response.domain.model.ResponseImpl;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

public class PrincipalDetailsImpl extends ResponseImpl implements PrincipalDetails, Principal {

    private Collection<? extends GrantedAuthority> authorities;
    private String username, password, contact, email;

    public PrincipalDetailsImpl(){

    }

    public PrincipalDetailsImpl(String username, String password, String contact, String email, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.email = email;
        this.authorities = authorities;
    }


    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String getContact() {
        return this.contact;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getName() {
        return null;
    }
}
