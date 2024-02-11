package com.med.securityservice.service;

import com.med.securityservice.entity.Role;
import com.med.securityservice.exception.ConflictException;
import com.med.securityservice.exception.RessourceNotFoundException;
import com.med.securityservice.repositry.RoleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoleService {
    @Autowired
    RoleRepositry roleRepositry ;
    public Role getRoleByRoleName(String roleName) {
        Role role =  null  ;
        try{
            role = roleRepositry.findByRoleName(roleName).get();
            return role ;
        }catch ( NoSuchElementException ex ){
            throw new RessourceNotFoundException(ex.getMessage()) ;
        }
    }
    public Role saveRole(String roleName)  {
        Role role = roleRepositry.findByRoleName(roleName).orElse(null);
        if( role != null ) throw new ConflictException("the role already exist") ;
        return roleRepositry.save(Role.builder()
                .roleName(roleName)
                .build()) ;
    }
    public List<Role> findAllRoles()  {
        return roleRepositry.findAll() ;
    }
}
