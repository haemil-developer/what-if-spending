package com.example.spending.domain.account.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;


@Entity
@Table
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String tokenSymbol;

    private BigDecimal balance;

    private Instant createdAt;
}
