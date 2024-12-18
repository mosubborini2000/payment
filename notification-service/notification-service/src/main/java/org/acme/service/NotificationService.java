package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.dto.NotificationRequest;
import org.acme.dto.NotificationResponse;
import org.acme.exception.Exception;
import org.acme.model.Audit;
import org.acme.model.Notification;
import org.acme.repositories.AuditLogRepository;
import org.acme.repositories.NotificationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;

@ApplicationScoped
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final AuditLogRepository auditRepository;

    @RestClient
    MessageServiceClient messageServiceClient;

    public NotificationService(NotificationRepository notificationRepository, AuditLogRepository auditRepository) {
        this.notificationRepository = notificationRepository;
        this.auditRepository = auditRepository;
    }

    @Transactional
    public NotificationResponse createNotification(NotificationRequest request) {
        String requestPayload = "";
        String responsePayload = "";
        int responseStatusCode = 0;
        String endpoint = "/message/" + request.getMessageId();

        try {
            requestPayload = request.toString();

            var message = messageServiceClient.getMessageById(Long.parseLong(request.getMessageId()));

            if (message.getStatus() == "1111") {
                throw new Exception("ERROR", "Message endpoint returned invalid status code: 1111");
            }

            responsePayload = message.toString();
            responseStatusCode = 200;


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

        } catch (Exception e) {
            throw e;
        } catch (java.lang.Exception e) {
            responsePayload = e.getMessage();
            responseStatusCode = 500;
            throw e;
        } finally {

            Audit audit = Audit.builder()
                    .endpoint(endpoint)
                    .httpMethod("post")
                    .requestPayload(requestPayload)
                    .responsePayload(responsePayload)
                    .responseStatusCode(responseStatusCode)
                    .timestamp(LocalDateTime.now())
                    .build();

            auditRepository.persist(audit);
        }
    }
}
