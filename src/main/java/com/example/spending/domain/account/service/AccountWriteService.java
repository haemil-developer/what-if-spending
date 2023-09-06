package com.example.spending.domain.account.service;

import com.example.spending.domain.account.entity.Account;
import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.account.repository.AccountRepository;
import com.example.spending.domain.token.dto.TokenDto;
import com.example.spending.domain.token.entity.Network;
import com.example.spending.domain.token.service.TokenReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountWriteService {
    private final AccountRepository accountRepository;
    private final TokenReadService tokenReadService;

    public void createAccounts(Long userId, ClientId clientId) {
        List<Account> accounts = tokenReadService.getTokens(null)
                .stream()
                .filter(tokenDto -> tokenDto.network() == Network.LOCAL)
                .map(tokenDto -> Account.create(userId, clientId, tokenDto.symbol(), "system"))
                .collect(Collectors.toList());
        accountRepository.saveAll(accounts);
    }
}
