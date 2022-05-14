package com.esekelvin.fraud.api;

import com.esekelvin.clients.fraud.FraudCheckResponse;
import com.esekelvin.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse fraudCheckResponse(@PathVariable("customerId") Integer customerId)
    {
       Boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
       log.info("Fraud check for customer {}", customerId);
       return new FraudCheckResponse(isFraudulentCustomer);
    }


}
