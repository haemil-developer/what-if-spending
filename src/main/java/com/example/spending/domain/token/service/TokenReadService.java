package com.example.spending.domain.token.service;

import com.example.spending.domain.token.dto.SearchTokenCommand;
import com.example.spending.domain.token.dto.TokenDto;
import com.example.spending.domain.token.entity.Token;
import com.example.spending.domain.token.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TokenReadService {
    private final TokenRepository tokenRepository;

    public List<TokenDto> getTokens(SearchTokenCommand command) {
        List<Token> tokens = tokenRepository.findAll();
        return tokens.stream().map(this::toDto).collect(Collectors.toList());
    }

    public TokenDto getToken(Long id) {
        return tokenRepository.findById(id).map(this::toDto).orElseThrow(RuntimeException::new);
    }

    private TokenDto toDto(Token token) {
        return new TokenDto(token.getSymbol(), token.getName(), token.getNetwork(), token.getDecimal(), token.getSupply(), token.getLogoUrl(), token.getActivate(), token.getCreatedAt(), token.getCreatedBy(), token.getLastModifiedAt(), token.getLastModifiedBy());
    }
}
