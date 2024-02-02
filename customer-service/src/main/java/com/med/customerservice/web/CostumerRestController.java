package com.med.customerservice.web;

import com.med.customerservice.dto.CostumerRequest;
import com.med.customerservice.entity.Costumer;
import com.med.customerservice.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer/")
public class CostumerRestController {
    @Autowired
    CostumerService costumerService ;
    @GetMapping("/")
    public List<Costumer> getAll() {
        return costumerService.getAllCostumer();
    }
    @GetMapping("/{id}")
    public Costumer getById(@PathVariable String id ) {
        return costumerService.getCostumerById(id) ;
    }
    @PostMapping("/")
    public Costumer saveCostumer(@RequestBody CostumerRequest costumerRequest) {
        return costumerService.saveCostumer(costumerRequest) ;
    }
}
