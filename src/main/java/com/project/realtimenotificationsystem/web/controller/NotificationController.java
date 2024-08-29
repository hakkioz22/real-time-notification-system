package com.project.realtimenotificationsystem.web.controller;

import com.project.realtimenotificationsystem.core.dto.NotificationDto;
import com.project.realtimenotificationsystem.core.model.Notification;
import com.project.realtimenotificationsystem.core.service.NotificationService;
import com.project.realtimenotificationsystem.core.service.impl.NotificationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationServiceImpl notificationServiceImpl;

    public NotificationController(NotificationService notificationService, NotificationServiceImpl notificationServiceImpl) {
        this.notificationService = notificationService;
        this.notificationServiceImpl = notificationServiceImpl;
    }

    @PostMapping("/create-notification")
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationDto notificationDto) {
        // Create notification
        return notificationService.createNotification(notificationDto);
    }

    @GetMapping("/get-notification")
    public ResponseEntity<Notification> getNotificationById(@RequestParam String id) {
        // Get notification by id
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/get-all-notifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        // Get all notifications
        return notificationService.getAllNotifications();
    }

    @PutMapping("/update-notification-status")
    public ResponseEntity<Notification> updateNotificationStatus(@RequestParam String id,@RequestParam String status) {
        // Update notification status
        return notificationService.updateNotificationStatus(id, status);
    }

    @DeleteMapping("/delete-notification")
    public ResponseEntity deleteNotification(@RequestParam String id) {
        // Delete notification
        return notificationService.deleteNotification(id);
    }
}
