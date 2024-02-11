package com.med.securityservice;

import com.med.securityservice.config.RsaKeyConfig;
import com.med.securityservice.dto.UserRequest;
import com.med.securityservice.service.RoleService;
import com.med.securityservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfig.class)
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
    //@Bean
    CommandLineRunner commandLineRunner(UserService userService, RoleService roleService ) {
        return args -> {
            userService.addRoleToUser("med","ADMIN");
        };
    }

}
