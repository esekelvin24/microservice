package com.esekelvin.customer.service;

import com.esekelvin.customer.model.Customer;
import com.esekelvin.customer.requests.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService() {
    public void registerCustomer(CustomerRegistrationRequest request) {
       Customer customer = Customer.builder()
               .firstName(request.firstName())
               .lastName(request.lastName())
               .email(request.email())
               .build();

       //todo: check if email valid
        // todo: check if email is not taken
        //todo: store customer in db
    }
}
