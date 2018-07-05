package com.internbacked.internbacked.auth.domain.model;


import javax.persistence.*;

@Entity
@Table(name="dt_user_role")
public class UserRoleImpl implements UserRole {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dt_user_role_id")
    private long id;

    @Column(name="dt_user_id")
    private long dt_user_id;

    @Column(name = "dt_accesslevel_id")
    private long dt_accesslevel_id;

    @Override
    public void setUserId(long userId) {
        this.dt_user_id =userId;
    }

    @Override
    public void setAccessLevelId(long accessLevelId) {
    this.dt_accesslevel_id =accessLevelId;
    }


    public UserRoleImpl() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
