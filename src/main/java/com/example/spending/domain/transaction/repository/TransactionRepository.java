package com.example.spending.domain.transaction.repository;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserIdAndClientIdOrderByIdDesc(Long userId, ClientId clientId);
}
