package com.med.securityservice.service;

import com.med.securityservice.dto.UserRequest;
import com.med.securityservice.entity.Role;
import com.med.securityservice.entity.User;
import com.med.securityservice.exception.ConflictException;
import com.med.securityservice.exception.RessourceNotFoundException;
import com.med.securityservice.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    UserRepositry userRepositry ;
    @Autowired
    PasswordEncoder passwordEncoder ;
    @Autowired
    RoleService roleService ;
    public User saveUser(UserRequest userRequest) {
        User userToTest = userToTest = userRepositry.findByUsername(userRequest.getUsername()).orElse(null);
        if(userToTest != null ) throw new ConflictException("the user is already exist") ;
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .email(userRequest.getEmail())
                .tel(userRequest.getTel())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .build();
        Role role = roleService.getRoleByRoleName("USER") ;
        if(user.getRoles() == null) {
            user.setRoles(new ArrayList<Role>());
            user.getRoles().add(role);
        }else {
            user.getRoles().add(role);
        }
        return userRepositry.save(user) ;
    }
    public User getUserByUsername(String username) {
        User user = null;
        try {
            user = userRepositry.findByUsername(username).get();
            return user ;
        }catch (NoSuchElementException ex) {
            throw new RessourceNotFoundException(ex.getMessage()) ;
        }
    }
    public List<User> findAll() {
        return userRepositry.findAll() ;
    }
    @Transactional
    public User addRoleToUser(String username , String roleName ) {
        User user = null ;
        Role role = null  ;
        try {
            user = userRepositry.findByUsername(username).get();
            try {
                role = roleService.getRoleByRoleName(roleName);
            }catch (RessourceNotFoundException ex) {
                role = roleService.saveRole(roleName) ;
            }
            user.getRoles().add(role);
            return user ;
        }catch (NoSuchElementException ex ) {
            throw new RessourceNotFoundException("the user is not exist") ;
        }
    }
}
