package com.internbacked.internbacked.auth.domain.dao;

import com.internbacked.internbacked.auth.api.vo.PrincipalVo;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetails;
import com.internbacked.internbacked.auth.domain.model.UserImpl;

public interface UserDao {
    PrincipalDetails findUserByUsername(String username);
    PrincipalDetails registerNewUser(PrincipalVo principalVo);
}
