package com.example.spending.domain.token.entity;

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
@Table(name = "token")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Symbol symbol;

    private String name; // Galleon, Sickle, Knut

    private Network network;

    private Integer decimal;

    private BigDecimal supply;

    @Column(name = "logo_url")
    private String logoUrl;

    private Boolean activate;

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

    public Token(Symbol symbol, String name, Network network, Integer decimal, BigDecimal supply, String logoUrl, Boolean activate, String createdBy) {
        this.symbol = symbol;
        this.name = name;
        this.network = network;
        this.decimal = decimal;
        this.supply = supply;
        this.logoUrl = logoUrl;
        this.activate = activate;
        this.createdAt = Instant.now();
        this.createdBy = createdBy;
        this.lastModifiedAt = Instant.now();
        this.lastModifiedBy = createdBy;
    }

    public void update(String logoUrl, Boolean activate) {
        this.logoUrl = logoUrl;
        this.activate = activate;
    }
}
