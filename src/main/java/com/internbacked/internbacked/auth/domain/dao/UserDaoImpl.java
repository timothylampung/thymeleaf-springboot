package com.internbacked.internbacked.auth.domain.dao;


import com.internbacked.internbacked.auth.api.vo.PrincipalVo;
import com.internbacked.internbacked.auth.api.vo.RoleVo;
import com.internbacked.internbacked.auth.domain.model.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.ref.PhantomReference;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private
    EntityManager em;

    public UserDaoImpl(){

    }


    @Override
    public PrincipalDetails findUserByUsername(String username) {

        UserImpl user;
        PrincipalDetails principalDetails = new PrincipalDetailsImpl();

        try {
            Query q = em.createQuery("select e from UserImpl e where e.dtUserName in:username" ).setParameter("username",username);

             user = (UserImpl) q.getSingleResult();
             principalDetails.setUsername(user.getDtUserName());
             principalDetails.setContact(user.getDtUserContact());
             principalDetails.setEmail(user.getDtUserEmail());
             principalDetails.setPassword(user.getDtUserPassword());
             principalDetails.setMessage("Success");
             principalDetails.setSuccess(true);
            return principalDetails;
        } catch (Exception e) {
            principalDetails.setMessage(e.getMessage());
            principalDetails.setSuccess(false);
            e.printStackTrace();
            return principalDetails;
        }
    }

    @Override
    public PrincipalDetails registerNewUser(PrincipalVo principalVo) {

        PrincipalDetails principalDetails = new PrincipalDetailsImpl();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserImpl user = new UserImpl();




            user.setDtUserPassword(principalVo.getPassword());
            user.setDtUserContact(principalVo.getContact());
            user.setDtUserEmail(principalVo.getEmail());
            user.setDtUserName(principalVo.getUsername());
            user.setDtUserActiveStatus(true);
            user.setDtUserPassword(bCryptPasswordEncoder.encode(principalVo.getPassword()));

            try {
                em.persist(user);
                setRole(principalVo.getAuthorities(), user.getDtUserId());

            } catch (Exception e) {
                e.printStackTrace();
                principalDetails.setMessage(e.getMessage());
                principalDetails.setSuccess(false);
                return principalDetails;
            }



            try {

                return findUserByUsername(user.getDtUserName());

            } catch (Exception e) {
                e.printStackTrace();
                principalDetails.setMessage(e.getMessage());
                principalDetails.setSuccess(false);
            }

            return null;



    }


    private void setRole(Set<RoleVo> vos, long userId){

        for (RoleVo vo :vos){
            UserRole role = new UserRoleImpl();
            role.setAccessLevelId(vo.getDtAccessLevelId());
            role.setUserId(userId);
            try {
                em.persist(role);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
