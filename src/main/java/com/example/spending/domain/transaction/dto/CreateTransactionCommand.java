package com.example.spending.domain.transaction.dto;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.token.entity.Symbol;
import com.example.spending.domain.transaction.entity.Type;

import java.math.BigDecimal;

public record CreateTransactionCommand(
        ClientId clientId,
        Long userId,
        Type type,
        String title,
        String description,
        Symbol symbol,
        BigDecimal amount,
        String createdBy
) {
}
