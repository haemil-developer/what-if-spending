package com.example.spending.domain.transaction.entity;

import com.example.spending.domain.token.entity.Symbol;
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
@Table(name = "transaction_swap_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TransactionSwapRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "from_symbol")
    private Symbol fromSymbol;

    @Column(name = "from_amount")
    private BigDecimal fromAmount;

    private Symbol toSymbol;

    @Column(name = "to_amount")
    private BigDecimal toAmount;

    private String market;

    @Column(name = "request_quote")
    private BigDecimal requestQuote;

    @Column(name = "current_quote")
    private BigDecimal currentQuote;

    @Column(name = "acceptable_margin_rate")
    private Double acceptableMarginRate;

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

    public TransactionSwapRecord(Symbol fromSymbol, BigDecimal fromAmount, Symbol toSymbol, BigDecimal toAmount, String market, BigDecimal requestQuote, BigDecimal currentQuote, Double acceptableMarginRate, Long transactionId, String createdBy) {
        this.fromSymbol = fromSymbol;
        this.fromAmount = fromAmount;
        this.toSymbol = toSymbol;
        this.toAmount = toAmount;
        this.market = market;
        this.requestQuote = requestQuote;
        this.currentQuote = currentQuote;
        this.acceptableMarginRate = acceptableMarginRate;
        this.transactionId = transactionId;
        this.createdAt = Instant.now();
        this.createdBy = createdBy;
    }
}
