package com.example.spending.domain.account.service;

import com.example.spending.domain.account.dto.AccountDto;
import com.example.spending.domain.account.entity.Account;
import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.account.repository.AccountRepository;
import com.example.spending.domain.token.entity.Symbol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountReadService {
    private final AccountRepository accountRepository;

    public AccountDto getAccount(Long id) {
       return accountRepository.findById(id)
               .map(this::toDto)
               .orElseThrow(RuntimeException::new);
    }

    public List<AccountDto> getUserAccounts(Long userId, ClientId clientId) {
       return accountRepository.findByUserIdAndClientId(userId, clientId)
               .stream()
               .map(this::toDto)
               .collect(Collectors.toList());
    }

    public AccountDto getUserAccount(Long userId, Symbol symbol, ClientId clientId) {
        return accountRepository.findByUserIdAndSymbolAndClientId(userId, symbol, clientId)
                .map(this::toDto)
                .orElseThrow(RuntimeException::new);
    }

    private AccountDto toDto(Account account) {
        return new AccountDto(account.getId(), account.getUserId(), account.getClientId(), account.getSymbol(), account.getBalance());
    }
}
