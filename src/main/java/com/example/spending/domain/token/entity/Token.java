package com.example.spending.domain.token.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Symbol symbol;
}
