package com.med.securityservice.service;

import com.med.securityservice.entity.User;
import com.med.securityservice.exception.RessourceNotFoundException;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager ;
    @Autowired
    JwtEncoder jwtEncoder ;
    @Autowired
    JwtDecoder jwtDecoder ;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserService userService ;
    public Map<String , String > accessToken(String username , String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username , password));
        if(!authentication.isAuthenticated()){
            throw new RessourceNotFoundException("the username or password not valid");
        }

        return Map.of("access-token",this.generateAccessToken(username)
        , "refresh-token" , this.generateRefreshToken(username)) ;
    }
    public Map<String , String > refreshToken(String refreshToken) {
        String username = jwtDecoder.decode(refreshToken).getSubject() ;
        if(username == null ) throw new RessourceNotFoundException("invalid token") ;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username) ;
        return Map.of("access-token",this.generateAccessToken(username)
                , "refresh-token" , this.generateRefreshToken(username)) ;
    }
    public String generateAccessToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username) ;
        Instant instant = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(username)
                .issuedAt(instant)
                .expiresAt(instant.plus(2, ChronoUnit.MINUTES))
                .claim("scope" , userDetails.getAuthorities().stream().map(grantedAuthority -> grantedAuthority.getAuthority()).collect(Collectors.toList()))
                .build();
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        return token ;
    }
    public String generateRefreshToken(String username ) {
        Instant instant = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(username)
                .issuedAt(instant)
                .expiresAt(instant.plus(30, ChronoUnit.MINUTES))
                .build();
        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
        return token ;
    }
}
