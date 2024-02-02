package com.med.accountservice;

import com.med.accountservice.dto.AccountRequest;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(AccountService accountService) {
		return args -> {
			accountService.saveAccount(AccountRequest.builder()
							.currency("mad")
							.createdAt(LocalDate.now())
							.type(AccountType.CURRENT_ACCOUNT)
							.costumerId("5e54af1c-064b-403f-a6b0-e56ca783f80e")
							.balance(10000)
					.build());
			accountService.saveAccount(AccountRequest.builder()
					.currency("mad")
					.createdAt(LocalDate.now())
					.type(AccountType.CURRENT_ACCOUNT)
					.costumerId("548edbab-9239-42bb-89f7-debe0984ff20")
					.balance(70000)
					.build());
		};
	}
}
