package com.internbacked.internbacked.auth.domain.model;

import java.util.Set;

public interface User {

    long getDtUserId();

    void setDtUserId(long dtUserId);


    String getDtUserName();

    void setDtUserName(String dtUserName);


    String getDtUserContact();

    void setDtUserContact(String dtUserContact);


    String getDtUserEmail();

    void setDtUserEmail(String dtUserEmail);


    String getDtUserPassword();

    void setDtUserPassword(String dtUserPassword);


    String getDtUserActiveStatus();

    void setDtUserActiveStatus(String dtUserActiveStatus);

     Set<RoleImpl> getRoles();

     void setRoles(Set<RoleImpl> roles);
}
