package org.acme.dto;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest {
    private String messageId;
    private String notificationType;
}
