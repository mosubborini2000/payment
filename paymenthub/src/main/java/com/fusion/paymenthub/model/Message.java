package com.fusion.paymenthub.model;
import lombok.*;
import java.util.Date;
import jakarta.persistence.*;


@Entity
@Setter
@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FUSION_MESSAGE_NEW")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    @SequenceGenerator(name = "message_seq", sequenceName = "message_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Embedded
    private Header header;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "amount_currancy")
    private String amountCurrency;

    @Column(name = "instructed_amount")
    private Double instructedAmount;

    @Column(name = "instructed_amount_currancy")
    private String instructedAmountCurrency;

    @Column(name = "exchange_rate")
    private Double exchangeRate;

    @Column(name = "value_date")
    private Date valueDate;

    @Column(name = "debtor_bank")
    private String debtorBank;

    @Column(name = "customer_account")
    private String customerAccount;

    @Column(name = "ordering_customer_name")
    private String orderingCustomerName;

    @Column(name = "debtor_address")
    private String debtorAddress;

    @Column(name = "beneficiary_bank")
    private String beneficiaryBank;

    @Column(name = "beneficiary_customer_name")
    private String beneficiaryCustomerName;

    @Column(name = "beneficiary_customer_account")
    private String beneficiaryCustomerAccount;

    @Column(name = "beneficiary_address")
    private String beneficiaryAddress;

    @Column(name = "document_no")
    private String documentNo;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "charge_bearer")
    private String chargeBearer;

    @Column(name = "charge_amount")
    private Double chargeAmount;

    @Column(name = "charge_amount_currancy")
    private String chargeAmountCurrency;

    @Column(name = "remittance_information")
    private String remittanceInformation;

    @Column(name = "document_date")
    private Date documentDate;

    @Column(name = "regulatory_reporting")
    private String regulatoryReporting;

    @Column(name = "instruction_for_next_agent")
    private String instructionForNextAgent;

    @Column(name = "status")
    private String status;

}






