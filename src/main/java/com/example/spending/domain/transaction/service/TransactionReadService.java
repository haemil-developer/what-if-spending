package com.example.spending.domain.transaction.service;

import com.example.spending.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionReadService {
    private final TransactionRepository transactionRepository;
}
