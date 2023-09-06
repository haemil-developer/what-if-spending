package com.example.spending.domain.token.dto;

import com.example.spending.domain.token.entity.Network;
import com.example.spending.domain.token.entity.Symbol;

public record SearchTokenCommand(
        Long id,
        Symbol symbol,
        String name,
        Network network
) {
}
