package com.internbacked.internbacked.auth.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="dt_user")
public class UserImpl implements User, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dt_user_id")
  private long dtUserId;

  @Column(name = "dt_user_name")
  private String dtUserName;
  @Column(name="dt_user_contact")
  private String dtUserContact;
  @Column(name="dt_user_email")
  private String dtUserEmail;
//  @Column(name= "dt_user_access_level_id")
//  private long dtUserAccessLevel;
  @Column(name="dt_user_password")
  private String dtUserPassword;
  @Column(name="dt_user_active_status")
  private String dtUserActiveStatus;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinTable(name = "dt_user_role", joinColumns = @JoinColumn(name = "dt_user_id"), inverseJoinColumns = @JoinColumn(name = "dt_accsess_level_id"))
  private Set<RoleImpl>roles;

  public UserImpl() {
  }


  public UserImpl(UserImpl user) {
   user.dtUserActiveStatus = user.getDtUserActiveStatus();
   user.dtUserContact = user.getDtUserContact();
    user.dtUserEmail=user.getDtUserEmail();
    user.dtUserId=user.getDtUserId();
   user.dtUserName= user.getDtUserName();
    user.dtUserPassword = user.getDtUserPassword();
    user.roles = user.getRoles();
  }



  public UserImpl(String dtUserName, String dtUserContact, String dtUserEmail, String dtUserPassword, String dtUserActiveStatus, Set<RoleImpl> roles) {
    this.dtUserName = dtUserName;
    this.dtUserContact = dtUserContact;
    this.dtUserEmail = dtUserEmail;
    this.dtUserPassword = dtUserPassword;
    this.dtUserActiveStatus = dtUserActiveStatus;
    this.roles = roles;
  }

  public long getDtUserId() {
    return dtUserId;
  }

  public void setDtUserId(long dtUserId) {
    this.dtUserId = dtUserId;
  }


  public String getDtUserName() {
    return dtUserName;
  }

  public void setDtUserName(String dtUserName) {
    this.dtUserName = dtUserName;
  }


  public String getDtUserContact() {
    return dtUserContact;
  }

  public void setDtUserContact(String dtUserContact) {
    this.dtUserContact = dtUserContact;
  }


  public String getDtUserEmail() {
    return dtUserEmail;
  }

  public void setDtUserEmail(String dtUserEmail) {
    this.dtUserEmail = dtUserEmail;
  }


//  public long getDtUserAccessLevel() {
//    return dtUserAccessLevel;
//  }
//
//  public void setDtUserAccessLevel(long dtUserAccessLevel) {
//    this.dtUserAccessLevel = dtUserAccessLevel;
//  }


  public String getDtUserPassword() {
    return dtUserPassword;
  }

  public void setDtUserPassword(String dtUserPassword) {
    this.dtUserPassword = dtUserPassword;
  }


  public String getDtUserActiveStatus() {
    return dtUserActiveStatus;
  }

  public void setDtUserActiveStatus(String dtUserActiveStatus) {
    this.dtUserActiveStatus = dtUserActiveStatus;
  }

  public Set<RoleImpl> getRoles() {
    return roles;
  }

  public void setRoles(Set<RoleImpl> roles) {
    this.roles = roles;
  }

}
