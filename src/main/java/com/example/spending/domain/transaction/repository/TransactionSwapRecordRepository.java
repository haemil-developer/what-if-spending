package com.example.spending.domain.transaction.repository;

import com.example.spending.domain.transaction.entity.TransactionSwapRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionSwapRecordRepository extends JpaRepository<TransactionSwapRecord, Long> {
}
