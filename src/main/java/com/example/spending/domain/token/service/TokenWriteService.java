package com.example.spending.domain.token.service;

import com.example.spending.domain.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenWriteService {
    private final TokenRepository tokenRepository;
}
