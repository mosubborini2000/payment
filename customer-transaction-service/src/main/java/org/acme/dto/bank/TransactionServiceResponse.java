package org.acme.dto.bank;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionServiceResponse {
    private String transactionId;
    private Double amount;
    private String transactionType; // "CREDIT" or "DEBIT"
    private String timestamp;
}
