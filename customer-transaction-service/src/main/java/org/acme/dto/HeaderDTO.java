package org.acme.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderDTO {
    private String sourceSystem;
    private String sourceBank;
    private String timestamp;
}