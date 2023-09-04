package com.example.spending.controller;

import com.example.spending.domain.account.service.AccountWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountWriteService accountWriteService;

    @PostMapping("/{userId}")
    public void create(@PathVariable Long userId) {
        accountWriteService.create();
    }
}
