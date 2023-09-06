package com.example.spending.domain.token.dto;

import com.example.spending.domain.token.entity.Network;
import com.example.spending.domain.token.entity.Symbol;

import java.math.BigDecimal;

public record CreateTokenCommand(
      Symbol symbol,
      String name,
      Network network,
      Integer decimal,
      BigDecimal supply,
      String logoUrl,
      Boolean activate,
      String createdBy
) {
}