package com.example.spending.controller;

import com.example.spending.domain.transaction.service.TransactionReadService;
import com.example.spending.domain.transaction.service.TransactionWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionReadService transactionReadService;
    private final TransactionWriteService transactionWriteService;
}
