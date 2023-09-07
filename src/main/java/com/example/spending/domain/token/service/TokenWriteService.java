package com.example.spending.domain.token.service;

import com.example.spending.domain.token.dto.CreateTokenCommand;
import com.example.spending.domain.token.dto.UpdateTokenCommand;
import com.example.spending.domain.token.entity.Token;
import com.example.spending.domain.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenWriteService {
    private final TokenRepository tokenRepository;

    public void createToken(CreateTokenCommand command) {
        Token token = new Token(
                command.symbol(),
                command.name(),
                command.network(),
                command.decimal(),
                command.supply(),
                command.logoUrl(),
                command.activate(),
                command.createdBy()
        );
        tokenRepository.save(token);
    }

    public void updateToken(Long id, UpdateTokenCommand command) {
        Token token = tokenRepository.findById(id).orElseThrow(RuntimeException::new);
        token.update(command.logoUrl(), command.activate());
    }
}
