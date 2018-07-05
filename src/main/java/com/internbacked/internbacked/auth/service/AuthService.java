package com.internbacked.internbacked.auth.service;

import com.internbacked.internbacked.auth.api.vo.PrincipalVo;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetails;

public interface AuthService {
    PrincipalDetails registerNewUser(PrincipalVo principalVo);
    PrincipalDetails findUserByUsername(String s);
}
