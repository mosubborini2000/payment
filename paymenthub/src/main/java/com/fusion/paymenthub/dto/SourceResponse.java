package com.fusion.paymenthub.dto;

import lombok.*;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceResponse {
    private String sourceSystem;
    private String sourceBank;
}
