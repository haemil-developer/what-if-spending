package com.example.spending.application.controller;

import com.example.spending.domain.token.dto.CreateTokenCommand;
import com.example.spending.domain.token.dto.SearchTokenCommand;
import com.example.spending.domain.token.dto.TokenDto;
import com.example.spending.domain.token.dto.UpdateTokenCommand;
import com.example.spending.domain.token.service.TokenReadService;
import com.example.spending.domain.token.service.TokenWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tokens")
@RequiredArgsConstructor
public class TokenController {
    private final TokenReadService tokenReadService;
    private final TokenWriteService tokenWriteService;

    @PostMapping("")
    public void createToken(@RequestBody CreateTokenCommand command) {
        tokenWriteService.createToken(command);
    }

    @GetMapping("")
    public List<TokenDto> getTokens(@RequestParam SearchTokenCommand command) {
        return tokenReadService.getTokens(command);
    }

    @GetMapping("/{id}")
    public TokenDto getToken(@PathVariable("id") Long id) {
        return tokenReadService.getToken(id);
    }

    @PutMapping("/{id}")
    public void updateToken(@PathVariable("id") Long id, @RequestBody UpdateTokenCommand command) {
        tokenWriteService.updateToken(id, command);
    }
}
