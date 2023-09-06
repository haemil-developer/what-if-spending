package com.example.spending.domain.account.dto;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.token.entity.Symbol;

import java.math.BigDecimal;

public record AccountDto(
        Long Id,
        Long userId,
        ClientId clientId,
        Symbol symbol,
        BigDecimal balance
) {
}
