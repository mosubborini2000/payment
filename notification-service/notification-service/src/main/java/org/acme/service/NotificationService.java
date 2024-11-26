package org.acme.service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.NotificationRequest;
import org.acme.dto.NotificationResponse;
import org.acme.model.Notification;
import org.acme.repositories.NotificationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @RestClient
    MessageServiceClient messageServiceClient;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public NotificationResponse createNotification(NotificationRequest request) {
        var message = messageServiceClient.getMessageById(Long.parseLong(request.getMessageId()));

        Notification notification = new Notification();
        notification.setMessageId(request.getMessageId());
        notification.setNotificationType(request.getNotificationType());
        notification.setNotificationStatus("CREATED");

        notificationRepository.persist(notification);

        NotificationResponse response = new NotificationResponse();
        response.setId(notification.getId());
        response.setMessageId(notification.getMessageId());
        response.setNotificationStatus(notification.getNotificationStatus());
        response.setNotificationType(notification.getNotificationType());
        return response;
    }
}
