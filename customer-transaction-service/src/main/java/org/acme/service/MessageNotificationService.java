package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.MessageResponseDTO;
import org.acme.dto.NotificationRequestDTO;
import org.acme.dto.NotificationResponseDTO;
import org.acme.mapper.MessageNotificationMapper;
import org.acme.model.MessageNotification;
import org.acme.service.rest.MessageClient;
import org.acme.service.rest.NotificationClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class MessageNotificationService {
    @Inject
    @RestClient
    MessageClient messageClient;

    @Inject
    @RestClient
    NotificationClient notificationClient;

    @Inject
    MessageNotificationMapper mapper;

    public MessageNotification processMessageNotification(Long messageId, NotificationRequestDTO notificationRequest) {
        MessageResponseDTO messageResponse = messageClient.getMessageById(messageId);

        NotificationResponseDTO notificationResponse = notificationClient.createNotification(notificationRequest);

        return mapper.toEntity(messageResponse, notificationResponse);
    }
}
