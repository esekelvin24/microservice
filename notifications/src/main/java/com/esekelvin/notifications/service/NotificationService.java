package com.esekelvin.notifications.service;

import com.esekelvin.clients.notification.NotificationRequest;
import com.esekelvin.notifications.model.Notification;
import com.esekelvin.notifications.repo.NotificationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepo notificationRepo;

    public void send(NotificationRequest notificationRequest)
    {
         notificationRepo.save(
                 Notification.builder()
                         .toCustomerId(notificationRequest.toCustomerId())
                         .toCustomerEmail(notificationRequest.toCustomerEmail())
                         .sender("esekelvin")
                         .message(notificationRequest.message())
                         .sentAt(LocalDateTime.now())
                         .build()
         );
    }

}
