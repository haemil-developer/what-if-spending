package com.example.spending.domain.token.repository;

import com.example.spending.domain.token.entity.TokenSupplyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenSupplyRecordRepository extends JpaRepository<TokenSupplyRecord, Long> {
}
