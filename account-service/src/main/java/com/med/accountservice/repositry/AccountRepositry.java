package com.med.accountservice.repositry;

import com.med.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositry extends JpaRepository<Account , String> {
}
