package com.example.spending.domain.transaction.service;

import com.example.spending.domain.transaction.dto.CreateTransactionSwapRecordCommand;
import com.example.spending.domain.transaction.entity.TransactionSwapRecord;
import com.example.spending.domain.transaction.repository.TransactionSwapRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionSwapRecordService {
    private final TransactionSwapRecordRepository transactionSwapRecordRepository;

    @Transactional
    public Long save(CreateTransactionSwapRecordCommand command) {
        TransactionSwapRecord transactionSwapRecord = new TransactionSwapRecord(
                command.fromSymbol(),
                command.fromAmount(),
                command.toSymbol(),
                command.toAmount(),
                command.market(),
                command.requestQuote(),
                command.currentQuote(),
                command.acceptableMarginRate(),
                command.transactionId(),
                command.createdBy()
        );
        return transactionSwapRecordRepository.save(transactionSwapRecord).getId();
    }
}
