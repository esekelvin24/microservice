package com.esekelvin.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/*
@FeignClient(
        name = "notification"
       // url = "${clients.notification.url}"
)*/
@FeignClient("NOTIFICATION")
public interface NotificationClient {

    @PostMapping(path = "api/v1/notification")
    public void sendNotification(NotificationRequest notificationRequest);
}
