package com.example.spending.application.controller;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.transaction.dto.CreateTransactionCommand;
import com.example.spending.domain.transaction.dto.TransactionDto;
import com.example.spending.domain.transaction.entity.Type;
import com.example.spending.domain.transaction.service.TransactionReadService;
import com.example.spending.domain.transaction.service.TransactionWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionReadService transactionReadService;
    private final TransactionWriteService transactionWriteService;

    @PostMapping("/pay")
    public void pay(@RequestBody CreateTransactionCommand command) {
        transactionWriteService.save(command);
    }

    @PostMapping("/reward")
    public void reward(@RequestBody CreateTransactionCommand command) {
        transactionWriteService.save(command);
    }

    @GetMapping("/users/{userId}/clients/{clientId}")
    public List<TransactionDto> getUserTransactions(@PathVariable("userId") Long userId,
                                                    @PathVariable("clientId") ClientId clientId) {
        return transactionReadService.getUserTransactions(userId,clientId);
    }
}
