package com.example.spending.domain.token.service;

import com.example.spending.domain.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TokenReadService {
    private final TokenRepository tokenRepository;
}
