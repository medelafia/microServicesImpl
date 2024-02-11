package com.med.securityservice.repositry;

import com.med.securityservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepositry extends JpaRepository<Role , Long> {
    public Optional<Role> findByRoleName(String roleName) ;
}
