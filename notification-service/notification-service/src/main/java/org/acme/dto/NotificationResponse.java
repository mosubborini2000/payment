package org.acme.dto;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private Long id;
    private String messageId;
    private String notificationStatus;
    private String notificationType;
}
