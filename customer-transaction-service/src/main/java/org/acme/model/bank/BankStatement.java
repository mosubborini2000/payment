package org.acme.model.bank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankStatement {
    @Id
    private String accountNumber;
    private String customerName;
    private String address;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions;
    private Double totalCredit;
    private Double totalDebit;
}
