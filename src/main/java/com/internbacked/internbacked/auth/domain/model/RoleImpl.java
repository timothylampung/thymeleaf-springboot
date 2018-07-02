package com.internbacked.internbacked.auth.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="dt_access_level")
public class RoleImpl implements Role, Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "dt_access_level_id")
  private long roleId;

  @Column(name="dt_access_level_role")
  private String dtAccessLevelRole;



  public RoleImpl() {
  }

  public RoleImpl(long roleId, String dtAccessLevelRole) {
    this.dtAccessLevelRole = dtAccessLevelRole;
    this.roleId = roleId;
  }



  public long getDtAccessLevelId() {
    return roleId;
  }

  public void setDtAccessLevelId(long roleId) {
    this.roleId = roleId;
  }


  public String getDtAccessLevelRole() {
    return dtAccessLevelRole;
  }

  public void setDtAccessLevelRole(String dtAccessLevelRole) {
    this.dtAccessLevelRole = dtAccessLevelRole;
  }

}
