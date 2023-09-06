package com.example.spending.domain.token.dto;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.token.entity.Symbol;
import com.example.spending.domain.transaction.entity.Type;

import java.math.BigDecimal;

public record CreateTokenSupplyRecordCommand(
        ClientId clientId,
        Symbol symbol,
        Type type,
        BigDecimal amount,
        BigDecimal preSupply,
        Long transactionId,
        String createdBy
) {
}
