package org.acme.model;
import jakarta.persistence.Embeddable;
import lombok.*;
@Embeddable
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderInfo {
    private String sourceSystem;
    private String sourceBank;
    private String timestamp;
}
