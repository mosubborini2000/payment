package com.fusion.paymenthub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public  class Source {

    @Column(name = "source_system")
    private String sourceSystem;

    @Column(name = "source_bank")
    private String sourceBank;
}
