package org.acme.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages_notifications")
public class MessageNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MessageInfo messageInfo;

    @Column(name = "notification_status")
    private String notificationStatus;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "combined_status")
    private String combinedStatus;
}


