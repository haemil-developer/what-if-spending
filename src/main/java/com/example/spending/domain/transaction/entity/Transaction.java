package com.example.spending.domain.transaction.entity;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.token.entity.Symbol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transaction")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public Transaction(Long userId, ClientId clientId, Type type, String title, String description, Symbol symbol, BigDecimal amount, String createdBy) {
        this.userId = userId;
        this.clientId = clientId;
        this.type = type;
        this.title = title;
        this.description = description;
        this.symbol = symbol;
        this.amount = amount;
        this.createdAt = Instant.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = Instant.now();
        this.lastModifiedBy = createdBy;
    }
}
