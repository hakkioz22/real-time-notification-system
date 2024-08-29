package com.project.realtimenotificationsystem.core.service;

import com.project.realtimenotificationsystem.core.dto.NotificationDto;
import com.project.realtimenotificationsystem.core.model.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
    ResponseEntity<Notification> createNotification(NotificationDto notificationDto);
    ResponseEntity<Notification> getNotificationById(String id);
    ResponseEntity<List<Notification>> getAllNotifications();
    ResponseEntity<Notification> updateNotificationStatus(String id, String status);
    ResponseEntity deleteNotification(String id);
}
