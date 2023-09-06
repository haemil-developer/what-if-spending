package com.example.spending.application.controller;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.account.service.AccountReadService;
import com.example.spending.domain.account.service.AccountWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountReadService accountReadService;
    private final AccountWriteService accountWriteService;

    @PostMapping("/{userId}/{clientId}")
    public void create(@PathVariable("userId") Long userId,
                       @PathVariable("clientId")ClientId clientId) {
        accountWriteService.createAccounts(userId, clientId);
    }

    @GetMapping("/{id}")
    public void getAccount(@PathVariable("id") Long id) {
        accountReadService.getAccount(id);
    }

    /*@GetMapping("/{userId}/{clientId}")
    public void getAccount(@PathVariable("userId") Long userId,
                           @PathVariable("clientId")ClientId clientId,
                           @RequestParam Symbol symbol) {
        accountReadService.getAccount(userId, clientId, symbol);
    }*/

    @GetMapping("/{userId}/{clientId}")
    public void getUserAccounts(@PathVariable("userId") Long userId,
                           @PathVariable("clientId")ClientId clientId) {
        accountReadService.getUserAccounts(userId, clientId);
    }
}
