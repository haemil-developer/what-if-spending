package com.example.spending.domain.token.entity;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.transaction.entity.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "token_supply_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenSupplyRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "client_id")
    @Enumerated(EnumType.STRING)
    private ClientId clientId;

    private Symbol symbol;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "pre_supply")
    private BigDecimal preSupply;

    @Column(name = "post_supply")
    private BigDecimal postSupply;

    @Column(name = "transaction_id")
    private Long transactionId;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    @JsonIgnore
    private Instant createdAt = Instant.now();

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    private String createdBy;

    public TokenSupplyRecord(ClientId clientId, Symbol symbol, BigDecimal amount, Type type, BigDecimal preSupply, Long transactionId, String createdBy) {
        this.clientId = clientId;
        this.symbol = symbol;
        this.amount = amount;
        this.type = type;
        this.preSupply = preSupply;
        this.postSupply = type == Type.DEPOSIT ? preSupply.add(amount) : preSupply.subtract(amount);
        this.transactionId = transactionId;
        this.createdAt = Instant.now();
        this.createdBy = createdBy;
    }
}
