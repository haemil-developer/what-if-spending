package com.example.spending.domain.token.dto;

import com.example.spending.domain.token.entity.Network;
import com.example.spending.domain.token.entity.Symbol;

import java.math.BigDecimal;
import java.time.Instant;

public record TokenDto(
        Symbol symbol,
        String name,
        Network network,
        Integer decimal,
        BigDecimal supply,
        String logoUrl,
        Boolean activate,
        Instant createdAt,
        String createdBy,
        Instant lastModifiedAt,
        String lastModifiedBy
) {
}
