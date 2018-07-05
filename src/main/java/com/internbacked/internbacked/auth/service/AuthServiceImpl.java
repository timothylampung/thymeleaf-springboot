package com.internbacked.internbacked.auth.service;

import com.internbacked.internbacked.auth.api.vo.PrincipalVo;
import com.internbacked.internbacked.auth.domain.dao.UserDao;
import com.internbacked.internbacked.auth.domain.model.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private final
    UserDao userDao;

    @Autowired
    public AuthServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public PrincipalDetails registerNewUser(PrincipalVo principalVo) {
        return userDao.registerNewUser(principalVo);
    }

    @Override
    public PrincipalDetails findUserByUsername(String s) {
        return userDao.findUserByUsername(s);
    }
}
