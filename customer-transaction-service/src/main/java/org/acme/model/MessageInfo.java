package org.acme.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageInfo {
    private String messageId;
    private Double amount;
    private String status;

    @Embedded
    private HeaderInfo headerInfo;
}