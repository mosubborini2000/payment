package com.fusion.paymenthub.dto;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    private HeaderResponse header;

    private Long reference;
    private Double amount;
    private String amountCurrency;
    private Double instructedAmount;
    private String instructedAmountCurrency;
    private Double exchangeRate;
    private Date valueDate;
    private String debtorBank;
    private String customerAccount;
    private String orderingCustomerName;
    private String debtorAddress;
    private String beneficiaryBank;
    private String beneficiaryCustomerName;
    private String beneficiaryCustomerAccount;
    private String beneficiaryAddress;
    private String documentNo;
    private String transactionType;
    private String chargeBearer;
    private Double chargeAmount;
    private String chargeAmountCurrency;
    private String remittanceInformation;
    private Date documentDate;
    private String regulatoryReporting;
    private String instructionForNextAgent;
    private String status;
}
