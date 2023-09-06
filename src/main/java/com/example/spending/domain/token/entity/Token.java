package com.example.spending.domain.token.entity;

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
@Table(name = "token")
@Getter
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

    private void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setNetwork(Network network) {
        this.network = network;
    }

    private void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }

    private void setSupply(BigDecimal supply) {
        this.supply = supply;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
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

    public static Token create(Symbol symbol, String name, Network network, Integer decimal, BigDecimal supply, String logoUrl, Boolean activate, String createdBy) {
        Token token = new Token();
        token.setSymbol(symbol);
        token.setName(name);
        token.setNetwork(network);
        token.setDecimal(decimal);
        token.setSupply(supply);
        token.setLogoUrl(logoUrl);
        token.setActivate(activate);
        token.setCreatedAt(Instant.now());
        token.setCreatedBy(createdBy);
        token.setLastModifiedAt(Instant.now());
        token.setLastModifiedBy(createdBy);
        return token;
    }
}
