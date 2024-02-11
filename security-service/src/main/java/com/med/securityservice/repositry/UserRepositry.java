package com.med.securityservice.repositry;

import com.med.securityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<User , Long > {
    public Optional<User> findByUsername(String username) ;
}
