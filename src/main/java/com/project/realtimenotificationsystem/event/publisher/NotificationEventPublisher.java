package com.project.realtimenotificationsystem.event.publisher;

import com.project.realtimenotificationsystem.event.NotificationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public NotificationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishNotificationEvent(NotificationEvent notificationEvent) {
        applicationEventPublisher.publishEvent(notificationEvent);
    }
}
