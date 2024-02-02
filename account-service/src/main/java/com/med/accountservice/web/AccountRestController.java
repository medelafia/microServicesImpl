package com.med.accountservice.web;

import com.med.accountservice.dto.AccountRequest;
import com.med.accountservice.entity.Account;
import com.med.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/")
public class AccountRestController {
    @Autowired
    AccountService accountService ;
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getAllAccounts() {
        return accountService.findAllAccounts() ;
    }
    @PostMapping ("/")
    public Account saveAccount(@RequestBody  AccountRequest accountRequest) {
        return accountService.saveAccount(accountRequest) ;
    }
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id){
        return accountService.findById(id) ;
    }
    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllAccounts() {
        accountService.deleteAll();
    }
    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable String id ) {
        accountService.deleteById(id);
    }
}
