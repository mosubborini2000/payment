package org.acme.dto.bank;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String address;
}
