package com.example.spending.domain.transaction.service;

import com.example.spending.domain.account.entity.Account;
import com.example.spending.domain.account.repository.AccountRepository;
import com.example.spending.domain.transaction.dto.CreateTransactionCommand;
import com.example.spending.domain.transaction.entity.Transaction;
import com.example.spending.domain.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionWriteService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public Long save(CreateTransactionCommand command) {
        Account userAccount = accountRepository.findByUserIdAndSymbolAndClientId(command.userId(), command.symbol(), command.clientId()).orElseThrow(RuntimeException::new);
        if( userAccount.getBalance().compareTo(command.amount() ) < 0) throw new RuntimeException();

        Transaction transaction = new Transaction(
                command.clientId(),
                userAccount,
                command.type(),
                command.title(),
                command.description(),
                command.symbol(),
                command.amount(),
                command.createdBy()
        );
        return transactionRepository.save(transaction).getId();
    }
}
