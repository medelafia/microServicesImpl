package com.med.securityservice.web;

import com.med.securityservice.dto.UserRequest;
import com.med.securityservice.entity.User;
import com.med.securityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @Autowired
    UserService userService ;
    @GetMapping("/")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public List<User> getAllUsers() {
        return userService.findAll() ;
    }
    @PostMapping("/registre")
    public User registreUser(@RequestBody UserRequest userRequest ) {
        return userService.saveUser(userRequest) ;
    }
}
