package com.fintech.monopostspr.repository;

import com.fintech.monopostspr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailOrPhoneNumber(String email, String phoneNumber);

    Optional<User> findByPhoneNumber(String phone);

}
