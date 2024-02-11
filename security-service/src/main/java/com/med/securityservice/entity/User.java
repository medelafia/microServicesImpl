package com.med.securityservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username ;
    private String email ;
    private String firstName ;
    private String lastName ;
    private Long tel ;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
    private String password ;
}
