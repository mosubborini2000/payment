package org.acme.controller;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.bank.BankStatementRequest;
import org.acme.service.BankStatementService;

@Path("/bank-statements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankStatementController {

    @Inject
    BankStatementService bankStatementService;

    @POST
    @Path("/create")
    public Response createBankStatement(BankStatementRequest requestDTO) {
        return bankStatementService.createBankStatementResponse(requestDTO.getCustomer(), requestDTO.getTransactions());
    }

    @GET
    @Path("/{accountNumber}")
    public Response getBankStatement(@PathParam("accountNumber") String accountNumber) {
        return bankStatementService.getBankStatementResponse(accountNumber);
    }
}
