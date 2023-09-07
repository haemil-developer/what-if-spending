package com.example.spending.domain.transaction.dto;

import com.example.spending.domain.token.entity.Symbol;

import java.math.BigDecimal;

public record CreateTransactionSwapRecordCommand(
        Symbol fromSymbol,
        BigDecimal fromAmount,
        Symbol toSymbol,
        BigDecimal toAmount,
        String market,
        BigDecimal requestQuote,
        BigDecimal currentQuote,
        Double acceptableMarginRate,
        Long transactionId,
        String createdBy
) {
}
