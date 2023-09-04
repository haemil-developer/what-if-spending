package com.example.spending.controller;

import com.example.spending.domain.token.service.TokenReadService;
import com.example.spending.domain.token.service.TokenWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
@RequiredArgsConstructor
public class TokenController {
    private final TokenReadService tokenReadService;
    private final TokenWriteService tokenWriteService;
}
