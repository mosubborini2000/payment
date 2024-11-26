package org.acme.service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.bank.CustomerServiceResponse;
import org.acme.dto.bank.TransactionServiceResponse;
import org.acme.mapper.BankStatementMapper;
import org.acme.model.bank.BankStatement;
import org.acme.repo.BankStatementRepository;
import java.util.List;

@ApplicationScoped
public class BankStatementService {

    @Inject
    BankStatementMapper bankStatementMapper;

    @Inject
    BankStatementRepository bankStatementRepository;
    @Transactional
    public Response createBankStatementResponse(CustomerServiceResponse customer, List<TransactionServiceResponse> transactions) {
        try {
            BankStatement bankStatement = bankStatementMapper.mapToBankStatement(customer, transactions);
            bankStatementRepository.persist(bankStatement);
            return Response.status(Response.Status.CREATED).entity(bankStatement).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating BankStatement: " + e.getMessage())
                    .build();
        }
    }

    public Response getBankStatementResponse(String accountNumber) {
        try {
            BankStatement bankStatement = bankStatementRepository.find("accountNumber", accountNumber).firstResult();
            if (bankStatement == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("BankStatement not found for account number: " + accountNumber)
                        .build();
            }
            return Response.ok(bankStatement).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error retrieving BankStatement: " + e.getMessage())
                    .build();
        }
    }
}
