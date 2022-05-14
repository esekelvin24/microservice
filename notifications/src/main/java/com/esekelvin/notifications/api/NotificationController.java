package com.esekelvin.notifications.api;

import com.esekelvin.clients.notification.NotificationRequest;
import com.esekelvin.notifications.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/notification")
@Slf4j
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;


    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest)
    {
        log.info("New notification {}", notificationRequest);
        notificationService.send(notificationRequest);
    }




}
