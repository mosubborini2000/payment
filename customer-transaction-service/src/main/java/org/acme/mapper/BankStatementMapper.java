package org.acme.mapper;

import org.acme.dto.bank.CustomerServiceResponse;
import org.acme.dto.bank.TransactionServiceResponse;
import org.acme.model.bank.BankStatement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BankStatementMapper {
    @Mapping(source = "customer.firstName", target = "customerName", qualifiedByName = "formatCustomerName")
    @Mapping(source = "transactions", target = "transactions")
    @Mapping(expression = "java(calculateTotalCredit(transactions))", target = "totalCredit")
    @Mapping(expression = "java(calculateTotalDebit(transactions))", target = "totalDebit")
    BankStatement mapToBankStatement(CustomerServiceResponse customer, List<TransactionServiceResponse> transactions);

    @Named("formatCustomerName")
    default String formatCustomerName(String firstName) {
        return "Customer: " + firstName;
    }

    default Double calculateTotalCredit(List<TransactionServiceResponse> transactions) {
        return transactions.stream()
                .filter(t -> "CREDIT".equalsIgnoreCase(t.getTransactionType()))
                .mapToDouble(TransactionServiceResponse::getAmount)
                .sum();
    }

    default Double calculateTotalDebit(List<TransactionServiceResponse> transactions) {
        return transactions.stream()
                .filter(t -> "DEBIT".equalsIgnoreCase(t.getTransactionType()))
                .mapToDouble(TransactionServiceResponse::getAmount)
                .sum();
    }
}
