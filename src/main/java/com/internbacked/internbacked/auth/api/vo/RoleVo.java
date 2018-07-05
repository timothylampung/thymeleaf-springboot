package com.internbacked.internbacked.auth.api.vo;

public class RoleVo {

    public RoleVo( long dtAccessLevelId) {
        this.dtAccessLevelId = dtAccessLevelId;
    }



    public long getDtAccessLevelId() {
        return dtAccessLevelId;
    }

    public void setDtAccessLevelId(long dtAccessLevelId) {
        this.dtAccessLevelId = dtAccessLevelId;
    }

    private long dtAccessLevelId;

    public RoleVo() {
    }



}
