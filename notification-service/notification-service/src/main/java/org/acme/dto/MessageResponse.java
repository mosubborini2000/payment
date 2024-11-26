package org.acme.dto;

import lombok.*;


@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private Long id;
    private Double amount;
    private String status;
}
