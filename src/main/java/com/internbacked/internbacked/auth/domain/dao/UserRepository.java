package com.internbacked.internbacked.auth.domain.dao;

import com.internbacked.internbacked.auth.domain.model.User;
import com.internbacked.internbacked.auth.domain.model.UserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserImpl,Integer> {
    Optional<UserImpl> findByDtUserName(String username);
 }
