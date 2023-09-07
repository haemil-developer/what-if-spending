package com.example.spending.domain.transaction.service;

import com.example.spending.domain.transaction.dto.CreateTransactionCommand;
import com.example.spending.domain.transaction.entity.Transaction;
import com.example.spending.domain.transaction.entity.Type;
import com.example.spending.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionWriteService {
    private final TransactionRepository transactionRepository;

    public void save(Type type, CreateTransactionCommand command) {
        Transaction transaction = new Transaction(
                command.userId(),
                command.clientId(),
                type,
                command.title(),
                command.description(),
                command.symbol(),
                command.amount(),
                command.createdBy());
        transactionRepository.save(transaction);
    }
}
