package com.med.customerservice.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class CostumerRequest {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String numberPhone ;
}
