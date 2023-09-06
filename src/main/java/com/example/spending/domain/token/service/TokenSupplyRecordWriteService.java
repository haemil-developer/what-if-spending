package com.example.spending.domain.token.service;

import com.example.spending.domain.token.dto.CreateTokenSupplyRecordCommand;
import com.example.spending.domain.token.entity.TokenSupplyRecord;
import com.example.spending.domain.token.repository.TokenSupplyRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TokenSupplyRecordWriteService {
    private final TokenSupplyRecordRepository tokenSupplyRecordRepository;

    public Long createTokenSupplyRecord(CreateTokenSupplyRecordCommand command) {
        TokenSupplyRecord tokenSupplyRecord = TokenSupplyRecord.create(
                command.clientId(),
                command.symbol(),
                command.type(),
                command.amount(),
                command.preSupply(),
                command.transactionId(),
                command.createdBy()
        );
        return tokenSupplyRecordRepository.save(tokenSupplyRecord).getId();
    }
}
