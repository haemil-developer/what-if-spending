package com.example.spending.domain.account.service;

import com.example.spending.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountWriteService {
    private final AccountRepository accountRepository;

    public void create() {

    }
}
