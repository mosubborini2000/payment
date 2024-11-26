package com.fusion.paymenthub.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderRequest {
    private String messageId;
    private Date timestamp;
    private SourceRequest source;
}
