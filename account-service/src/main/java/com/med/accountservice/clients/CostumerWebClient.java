package com.med.accountservice.clients;

import com.med.accountservice.model.Costumer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COSTUMER-SERVICE")
public interface CostumerWebClient {
    @GetMapping("/costumer/{id}")
    @CircuitBreaker(name = "costumerService" , fallbackMethod = "getDefaultCostumer")
    Costumer findById(@PathVariable String id);
    @GetMapping("/costumer/")
    List<Costumer> getAllCostumer() ;
    default Costumer getDefaultCostumer(String id , Exception ex) {
        return Costumer.builder()
                .id(id)
                .lastName("unavailable")
                .lastName("unavailable")
                .email("unavailable")
                .build();
    }
}
