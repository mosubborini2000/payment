package com.fusion.paymenthub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
    public class Header {
        
        @Column(name = "message_id")
        private String messageId;

        @Column(name = "timestamp")
        private Date timestamp;

        @Embedded
        private Source source;


    }