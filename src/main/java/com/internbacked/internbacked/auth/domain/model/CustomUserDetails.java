package com.internbacked.internbacked.auth.domain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails extends UserImpl implements UserDetails {

    private User thisUser;

    public CustomUserDetails(final UserImpl user) {
        super(user);
        thisUser = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<RoleImpl> roles = thisUser.getRoles();

        return roles.stream().map(role -> new SimpleGrantedAuthority( "ROLE_"+role.getDtAccessLevelRole())).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return thisUser.getDtUserPassword();
    }

    @Override
    public String getUsername() {
        return thisUser.getDtUserName() ;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
