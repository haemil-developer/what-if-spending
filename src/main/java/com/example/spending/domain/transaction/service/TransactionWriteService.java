package com.example.spending.domain.transaction.service;

import com.example.spending.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionWriteService {
    private final TransactionRepository transactionRepository;
}
