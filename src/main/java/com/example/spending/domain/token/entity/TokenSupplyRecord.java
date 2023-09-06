package com.example.spending.domain.token.entity;

import com.example.spending.domain.account.entity.ClientId;
import com.example.spending.domain.transaction.entity.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "token_supply_record")
@Getter
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

    private void setClientId(ClientId clientId) {
        this.clientId = clientId;
    }

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    private void setType(Type type) {
        this.type = type;
    }

    private void setPreSupply(BigDecimal preSupply) {
        this.preSupply = preSupply;
    }

    private void setPostSupply(BigDecimal postSupply) {
        this.postSupply = postSupply;
    }

    private void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    private void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    private void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public static TokenSupplyRecord create(ClientId clientId, Symbol symbol, Type type, BigDecimal amount, BigDecimal preSupply, Long transactionId, String createdBy) {
        TokenSupplyRecord record = new TokenSupplyRecord();
        record.setClientId(Objects.requireNonNull(clientId));
        record.setSymbol(Objects.requireNonNull(symbol));
        record.setType(Objects.requireNonNull(type));
        record.setAmount(Objects.requireNonNull(amount));
        record.setPreSupply(Objects.requireNonNull(preSupply));
        record.setPostSupply(type == Type.DEPOSIT ? preSupply.add(amount) : preSupply.subtract(amount));
        record.setTransactionId(Objects.requireNonNull(transactionId));
        record.setCreatedAt(Instant.now());
        record.setCreatedBy(createdBy);
        return record;
    }
}
