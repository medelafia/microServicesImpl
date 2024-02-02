package com.med.customerservice.service;

import com.med.customerservice.Mapper.CostumerMapper;
import com.med.customerservice.dto.CostumerRequest;
import com.med.customerservice.entity.Costumer;
import com.med.customerservice.repositry.CostumerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CostumerService {
    @Autowired
    CostumerRepositry costumerRepositry ;

    public List<Costumer> getAllCostumer() {
        return costumerRepositry.findAll();
    }
    public Costumer saveCostumer(CostumerRequest costumerRequest ) {
        Costumer costumer = Costumer.builder()
                .id(UUID.randomUUID().toString())
                .firstName(costumerRequest.getFirstName())
                .lastName(costumerRequest.getLastName())
                .email(costumerRequest.getEmail())
                .numberPhone(costumerRequest.getNumberPhone())
                .build() ;
        return costumerRepositry.save(costumer);
    }
    public Costumer getCostumerById(String id) {
        return costumerRepositry.findById(id).orElseThrow();
    }
}
