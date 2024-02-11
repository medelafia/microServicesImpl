package com.med.securityservice.web;

import com.med.securityservice.entity.Role;
import com.med.securityservice.service.RoleService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleRestController {
    @Autowired
    RoleService roleService ;
    @PostMapping("/")
    public Role saveRole(String roleName) {
        return roleService.saveRole(roleName) ;
    }
    @GetMapping("/")
    public List<Role> findAllRole() {
        return roleService.findAllRoles() ;
    }
}
