package com.portx.dlovero.supplierRestClient.services;

import com.portx.dlovero.supplierRestClient.clients.PaymentClient;
import com.portx.dlovero.supplierRestClient.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PaymentService {

    private final PaymentClient paymentClient;

    @Autowired
    PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public void execute(Integer timesToSend) {
        List<Payment> payments = new ArrayList<>();
        // So it uses i as index without repeating!
        for (int i = 1; i <= timesToSend * 4; i = i + 4) {
            AmountPaid amountPaid = new AmountPaid(BigDecimal.valueOf(randomFloat()), randomCurrency());
            Customer originator = new Customer((long) i, "Customer " + i);
            Customer beneficiary = new Customer((long) i + 1, "Customer " + (i + 1));
            Account sender = new Account((long) i + 2, "CA");
            Account receiver = new Account((long) i + 3, "CA");
            Payment payment = new Payment(amountPaid, originator, beneficiary, sender, receiver, PAYMENT_STATUS.SENT);
            payments.add(payment);
        }

        paymentClient.sendPayments(payments);
        System.out.println("Shutting down...");
    }

    private String randomCurrency() {
        float random = new Random().nextInt();
        if (random % 2 == 0) {
            return "USD";
        }
        return "ARS";
    }

    private float randomFloat() {
        float leftLimit = 1F;
        float rightLimit = 1000000F;
        return leftLimit + new Random().nextFloat() * (rightLimit - leftLimit);
    }
}

