package com.fusion.paymenthub.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceRequest {
    private String sourceSystem;
    private String sourceBank;
}
