package com.project.realtimenotificationsystem.core.repository;

import com.project.realtimenotificationsystem.core.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
}
