package org.acme.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponseDTO {
    private Long id;
    private String messageId;
    private String notificationStatus;
    private String notificationType;
}