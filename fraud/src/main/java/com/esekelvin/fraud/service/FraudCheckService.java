package com.esekelvin.fraud.service;

import com.esekelvin.fraud.model.FraudCheckHistory;
import com.esekelvin.fraud.repo.FraudCheckHistoryRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Data
@Service
@AllArgsConstructor
public class FraudCheckService {


    private final FraudCheckHistoryRepo fraudCheckHistoryRepo;

    public Boolean isFraudulentCustomer(int customerId)
    {
        fraudCheckHistoryRepo.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(customerId)
                        .createdAt(LocalDate.now())
                        .build()

        );
        return false;
    }

}
