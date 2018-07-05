package com.internbacked.internbacked.auth.domain.model;

import com.internbacked.internbacked.response.domain.model.Response;
import com.internbacked.internbacked.response.domain.model.ResponseImpl;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface PrincipalDetails extends Response {

    void setUsername(String username);
    String getUsername();

    void setPassword(String password);
    String getPassword();

    void setContact(String contact);
    String getContact();


    void setEmail(String email);
    String getEmail();

    void setAuthorities(Collection<? extends GrantedAuthority> authorities);
    Collection<? extends GrantedAuthority> getAuthorities();

}
