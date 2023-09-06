package com.example.spending.domain.token.dto;

public record UpdateTokenCommand(
        String logoUrl,
        Boolean activate
) {
}
