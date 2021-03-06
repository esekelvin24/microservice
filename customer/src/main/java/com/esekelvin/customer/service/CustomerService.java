package com.esekelvin.customer.service;

import com.esekelvin.clients.fraud.FraudCheckResponse;
import com.esekelvin.clients.fraud.FraudClient;
import com.esekelvin.clients.notification.NotificationClient;
import com.esekelvin.clients.notification.NotificationRequest;
import com.esekelvin.customer.model.Customer;
import com.esekelvin.customer.repo.CustomerRepo;
import com.esekelvin.customer.requests.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

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

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster())
        {
            throw new IllegalStateException("This user is a fraudster");
        }


        //todo: send notification
        //todo: make async and add to a queue
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, You just did it", customer.getFirstName())
                )
        );

    }
}
