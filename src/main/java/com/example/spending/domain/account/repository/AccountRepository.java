package com.example.spending.domain.account.repository;

import com.example.spending.domain.account.entity.Account;
import com.example.spending.domain.account.entity.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserIdAndClientId(Long userId, ClientId clientId);
}
