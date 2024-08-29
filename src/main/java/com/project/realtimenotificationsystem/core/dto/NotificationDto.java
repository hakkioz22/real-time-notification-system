package com.project.realtimenotificationsystem.core.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private String recipient;
    private String message;
    private String type;
    private String status;
}
