package org.acme.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AuditLog_notification")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endpoint;
    private String httpMethod;
    @Lob
    private String requestPayload;
    @Lob
    private String responsePayload;
    private int responseStatusCode;
    private LocalDateTime timestamp;
}
