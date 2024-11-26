package org.acme.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO {
    private Double amount;
    private String status;
    private HeaderDTO header;
}