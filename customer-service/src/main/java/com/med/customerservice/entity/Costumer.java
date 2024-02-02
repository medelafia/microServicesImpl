package com.med.customerservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Costumer {
    @Id
    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String numberPhone ;
}
