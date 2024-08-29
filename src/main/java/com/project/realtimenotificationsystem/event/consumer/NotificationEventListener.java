package com.project.realtimenotificationsystem.event.consumer;

import com.project.realtimenotificationsystem.event.NotificationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventListener {

    @EventListener
    public void handleNotificationEvent(NotificationEvent notificationEvent) {
        System.out.println("Notification Event Received: " + notificationEvent.getNotification().getMessage());
    }
}
