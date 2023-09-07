package com.example.spending.domain.transaction.service;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.transaction.dto.TransactionDto;
import com.example.spending.domain.transaction.entity.Transaction;
import com.example.spending.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionReadService {
    private final TransactionRepository transactionRepository;

    public List<TransactionDto> getUserTransactions(Long userId, ClientId clientId) {transactionRepository.findByUserIdAndClientIdOrderByIdDesc(userId, clientId);
        return transactionRepository.findByUserIdAndClientIdOrderByIdDesc(userId, clientId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(transaction.getId(), transaction.getClientId(), transaction.getAccount().getId(), transaction.getAccount().getUserId(), transaction.getType(), transaction.getTitle(), transaction.getDescription(), transaction.getSymbol(), transaction.getAmount(),transaction.getCreatedBy());
    }
}
