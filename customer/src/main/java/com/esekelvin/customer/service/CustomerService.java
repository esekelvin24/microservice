package com.esekelvin.customer.service;

import com.esekelvin.customer.model.Customer;
import com.esekelvin.customer.repo.CustomerRepo;
import com.esekelvin.customer.requests.CustomerRegistrationRequest;
import com.esekelvin.customer.response.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
       Customer customer = Customer.builder()
               .firstName(request.firstName())
               .lastName(request.lastName())
               .email(request.email())
               .build();

       //todo: check if email valid
        // todo: check if email is not taken

        //todo: store customer in db
        customerRepo.saveAndFlush(customer);

        //todo: check if customer is a fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if (fraudCheckResponse.isFraudster())
        {
            throw new IllegalStateException("This user is a fraudster");
        }


        //todo: send notification
    }
}
