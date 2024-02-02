package com.med.accountservice.model;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Costumer {
    private String id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String numberPhone ;
}
