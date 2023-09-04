package com.example.spending.domain.account.service;

import com.example.spending.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountReadService {
    private final AccountRepository accountRepository;
}
