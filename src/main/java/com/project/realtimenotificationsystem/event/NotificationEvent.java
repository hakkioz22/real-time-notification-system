package com.project.realtimenotificationsystem.event;

import com.project.realtimenotificationsystem.core.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotificationEvent {
    private Notification notification;

}
