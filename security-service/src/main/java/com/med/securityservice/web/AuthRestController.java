package com.med.securityservice.web;

import com.med.securityservice.service.AuthService;
import com.med.securityservice.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
    @Autowired
    AuthService authService ;
    @Autowired
    UserDetailsServiceImpl userDetailsService ;
    @PostMapping ("/token")
    public Map<String,String> getToken(String username, String password) {
        return authService.accessToken(username , password );
    }
    @PostMapping("/refresh")
    public Map<String,String> refreshToken(String refreshToken) {
        return authService.refreshToken(refreshToken) ;
    }

}
