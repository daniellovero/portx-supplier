package com.portx.dlovero.supplierRestClient.domain.model;

// If microservices share DTOs/Domain data objects some way this could be reused from there instead of duplicating it.
public class Payment {
    AmountPaid amountPaid;
    Customer originator;
    Customer beneficiary;
    Account sender;
    Account receiver;
    PAYMENT_STATUS status;

    public Payment(AmountPaid amountPaid, Customer originator, Customer beneficiary, Account sender, Account receiver, PAYMENT_STATUS status) {
        this.amountPaid = amountPaid;
        this.originator = originator;
        this.beneficiary = beneficiary;
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
    }

    public AmountPaid getAmountPaid() {
        return amountPaid;
    }

    public Customer getOriginator() {
        return originator;
    }

    public Customer getBeneficiary() {
        return beneficiary;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public PAYMENT_STATUS getStatus() {
        return status;
    }
}
