package com.med.customerservice.repositry;

import com.med.customerservice.entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepositry extends JpaRepository<Costumer, String> {
}
