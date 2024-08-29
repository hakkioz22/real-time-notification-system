package com.project.realtimenotificationsystem.core.service.impl;

import com.project.realtimenotificationsystem.channel.email.EmailNotificationService;
import com.project.realtimenotificationsystem.core.dto.NotificationDto;
import com.project.realtimenotificationsystem.core.model.Notification;
import com.project.realtimenotificationsystem.core.repository.NotificationRepository;
import com.project.realtimenotificationsystem.core.service.NotificationService;
import com.project.realtimenotificationsystem.event.NotificationEvent;
import com.project.realtimenotificationsystem.event.publisher.NotificationEventPublisher;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Service
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;
    private final NotificationEventPublisher notificationEventPublisher;
    private final EmailNotificationService emailNotificationService;

    public NotificationServiceImpl(NotificationRepository notificationRepository, ModelMapper modelMapper, NotificationEventPublisher notificationEventPublisher, EmailNotificationService emailNotificationService) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
        this.notificationEventPublisher = notificationEventPublisher;
        this.emailNotificationService = emailNotificationService;
    }

    @Override
    public ResponseEntity<Notification> createNotification(NotificationDto notificationDto) {
        Notification notification = modelMapper.map(notificationDto, Notification.class);
        notification.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(notification);
        notificationEventPublisher.publishNotificationEvent(new NotificationEvent(notification));
        emailNotificationService.sendEmail(notification.getRecipient(), "New Notification", notification.getMessage());
        return ResponseEntity.ok(notification);
    }

    @Override
    public ResponseEntity<Notification> getNotificationById(String id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ResponseEntity.ok(notification);
    }

    @Override
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notificationList = notificationRepository.findAll();
        if (notificationList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok(notificationList);
    }

    @Override
    public ResponseEntity<Notification> updateNotificationStatus(String id, String status) {
        Notification notification = notificationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        notification.setStatus(status);
        Notification updatedNotification = notificationRepository.save(notification);
        notificationEventPublisher.publishNotificationEvent(new NotificationEvent(updatedNotification));
        emailNotificationService.sendEmail(updatedNotification.getRecipient(), "Notification Updated", "Your notification has been updated");
        return ResponseEntity.ok(updatedNotification);
    }

    @Override
    public ResponseEntity deleteNotification(String id) {
        ResponseEntity<Notification> notification = getNotificationById(id);
        notificationRepository.deleteById(id);
        emailNotificationService.sendEmail(Objects.requireNonNull(notification.getBody()).getRecipient(), "Notification Deleted", "Your notification has been deleted");
        return ResponseEntity.ok().build();
    }

}
