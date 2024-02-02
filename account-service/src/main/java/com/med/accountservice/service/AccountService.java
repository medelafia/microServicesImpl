package com.med.accountservice.service;

import com.med.accountservice.clients.CostumerWebClient;
import com.med.accountservice.dto.AccountRequest;
import com.med.accountservice.entity.Account;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.model.Costumer;
import com.med.accountservice.repositry.AccountRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    AccountRepositry accountRepositry ;
    @Autowired
    CostumerWebClient  costumerWebClient ;
    public List<Account> findAllAccounts() {
        List<Account> accounts = accountRepositry.findAll();
        accounts.stream().forEach(account -> {
            Costumer costumer = costumerWebClient.findById(account.getCostumerId()) ;
            account.setCostumer(costumer);
        });
        return accounts;
    }
    public Account saveAccount(AccountRequest accountRequest ) {
        Account account = Account.builder()
                .id(UUID.randomUUID().toString())
                .balance(accountRequest.getBalance())
                .costumer(null)
                .costumerId(accountRequest.getCostumerId())
                .type(AccountType.CURRENT_ACCOUNT)
                .currency(accountRequest.getCurrency())
                .build();
        return accountRepositry.save(account);
    }

    public Account findById(String id) {
        Account account = accountRepositry.findById(id).get();
        Costumer costumer = costumerWebClient.findById(account.getCostumerId()) ;
        account.setCostumer(costumer);
        return account ;
    }
    public void deleteById(String id) {
        accountRepositry.deleteById(id);
    }
    public void deleteAll() {
        accountRepositry.deleteAll();
    }
}
