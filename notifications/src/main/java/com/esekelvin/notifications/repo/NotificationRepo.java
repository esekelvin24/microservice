package com.esekelvin.notifications.repo;

import com.esekelvin.notifications.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Integer> {
}
