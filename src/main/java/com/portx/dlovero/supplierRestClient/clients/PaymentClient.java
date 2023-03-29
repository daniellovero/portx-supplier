package com.portx.dlovero.supplierRestClient.clients;


import com.portx.dlovero.supplierRestClient.domain.model.Payment;

import java.util.List;

// It could be any protocol, I want to abstract that in here
public interface PaymentClient {

    void sendPayments(List<Payment> payments);
}
