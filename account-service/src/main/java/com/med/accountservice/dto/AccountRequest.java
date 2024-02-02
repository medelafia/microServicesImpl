package com.med.accountservice.dto;

import com.med.accountservice.enums.AccountType;
import com.med.accountservice.model.Costumer;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountRequest {
    private double balance ;
    private LocalDate createdAt ;
    private String currency ;
    private AccountType type ;
    private String costumerId ;
}
