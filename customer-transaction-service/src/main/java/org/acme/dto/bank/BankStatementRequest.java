package org.acme.dto.bank;

import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankStatementRequest {
    private CustomerServiceResponse customer;
    private List<TransactionServiceResponse> transactions;

}
