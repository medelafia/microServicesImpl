package com.med.securityservice.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor @Builder

public class UserRequest {
    private String username ;
    private String email ;
    private String firstName ;
    private String lastName ;
    private String password ;
    private Long tel ;
}
