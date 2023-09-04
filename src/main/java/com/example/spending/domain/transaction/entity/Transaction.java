package com.example.spending.domain.transaction.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Type type;

    private BigDecimal amount;
}
