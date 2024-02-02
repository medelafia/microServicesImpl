package com.med.accountservice.entity;

import com.med.accountservice.enums.AccountType;
import com.med.accountservice.model.Costumer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Account {
    @Id
    private String id ;
    private double balance ;
    private LocalDate createdAt ;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type ;
    @Transient
    private Costumer costumer ;
    private String costumerId ;
}
