package com.example.spending.domain.transaction.entity;

import com.example.spending.domain.account.entity.ClientId;
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
@Table(name = "transaction")
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "client_id")
    private ClientId clientId;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    private BigDecimal amount;

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModifiedAt(Instant lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public static Transaction create(Long userId, ClientId clientId, Type type, String title, String description, Symbol symbol, BigDecimal amount, String createdBy) {
        Transaction transaction = new Transaction();
        transaction.setUserId(userId);
        transaction.setClientId(clientId);
        transaction.setTitle(title);
        transaction.setDescription(description);
        transaction.setSymbol(symbol);
        transaction.setAmount(amount);
        transaction.setCreatedAt(Instant.now());
        transaction.setCreatedBy(createdBy);
        transaction.setLastModifiedAt(Instant.now());
        transaction.setLastModifiedBy(createdBy);
        return transaction;
    }
}
