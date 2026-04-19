package com.jobportal.repository;

import com.jobportal.model.Notification;
import com.jobportal.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class NotificationRepository {
    
    private static List<Notification> notifications = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong(1);
    
    public Notification save(Notification notification) {
        if (notification.getId() == null) {
            notification.setId(idCounter.getAndIncrement());
            notifications.add(notification);
        } else {
            for (int i = 0; i < notifications.size(); i++) {
                if (notifications.get(i).getId().equals(notification.getId())) {
                    notifications.set(i, notification);
                    break;
                }
            }
        }
        return notification;
    }
    
    public Optional<Notification> findById(Long id) {
        return notifications.stream()
                .filter(notif -> notif.getId().equals(id))
                .findFirst();
    }
    
    public List<Notification> findAll() {
        return new ArrayList<>(notifications);
    }
    
    public List<Notification> findByUser(User user) {
        return notifications.stream()
                .filter(notif -> notif.getUser() != null && notif.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }
    
    public List<Notification> findByUserAndIsRead(User user, boolean isRead) {
        return notifications.stream()
                .filter(notif -> notif.getUser() != null && notif.getUser().getId().equals(user.getId()) &&
                                notif.isRead() == isRead)
                .collect(Collectors.toList());
    }
    
    public List<Notification> findUnreadByUser(User user) {
        return findByUserAndIsRead(user, false);
    }
    
    public void markAsRead(Long id) {
        findById(id).ifPresent(notif -> notif.setRead(true));
    }
    
    public void markAllAsRead(User user) {
        notifications.stream()
                .filter(notif -> notif.getUser() != null && notif.getUser().getId().equals(user.getId()))
                .forEach(notif -> notif.setRead(true));
    }
    
    public void deleteById(Long id) {
        notifications.removeIf(notif -> notif.getId().equals(id));
    }
    
    public long countUnreadByUser(User user) {
        return notifications.stream()
                .filter(notif -> notif.getUser() != null && notif.getUser().getId().equals(user.getId()) &&
                                !notif.isRead())
                .count();
    }
    
    public void deleteByUser(User user) {
        notifications.removeIf(notif -> notif.getUser() != null && notif.getUser().getId().equals(user.getId()));
    }
}