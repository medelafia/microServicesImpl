package com.med.customerservice.Mapper;

import com.med.customerservice.dto.CostumerRequest;
import com.med.customerservice.entity.Costumer;

public class CostumerMapper {
    public static CostumerRequest toCostumerRequest(Costumer costumer ) {
        return CostumerRequest.builder()
                .lastName(costumer.getLastName())
                .firstName(costumer.getFirstName())
                .email(costumer.getEmail())
                .numberPhone(costumer.getNumberPhone())
                .build();
    }
}
