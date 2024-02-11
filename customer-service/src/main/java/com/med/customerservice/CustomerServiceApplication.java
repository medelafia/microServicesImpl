package com.med.customerservice;

import com.med.customerservice.config.RsaKeysConfig;
import com.med.customerservice.dto.CostumerRequest;
import com.med.customerservice.service.CostumerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeysConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CostumerService costumerService) {
        return  args -> {
           costumerService.saveCostumer(CostumerRequest.builder()
                           .firstName("mohamed")
                           .lastName("el afia")
                           .email("mohamedelafia016@gmail.com")
                           .numberPhone("0658045721")
                   .build()) ;
            costumerService.saveCostumer(CostumerRequest.builder()
                    .firstName("amin")
                    .lastName("el afia")
                    .email("aminelafia016@gmail.com")
                    .numberPhone("06580439")
                    .build()) ;

        };
    }
}
