package com.example.spending.domain.account.entity;

import com.example.spending.domain.token.entity.Symbol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Table(name = "account")
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_id")
    private ClientId clientId;

    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    private BigDecimal balance;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    private String createdBy;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    @JsonIgnore
    private Instant lastModifiedAt = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    private String lastModifiedBy;

    private void setUserId(Long userId) {
        this.userId = userId;
    }

    private void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    private void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    private void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public static Account create(Long userId, ClientId clientId, Symbol symbol, String createdBy) {
        Account account = new Account();
        account.setUserId(userId);
        account.setClientId(clientId);
        account.setSymbol(symbol);
        account.setBalance(BigDecimal.ZERO);
        account.setCreatedAt(Instant.now());
        account.setCreatedBy(createdBy);
        account.setLastModifiedAt(Instant.now());
        account.setLastModifiedBy(createdBy);
        return account;
    }
}
