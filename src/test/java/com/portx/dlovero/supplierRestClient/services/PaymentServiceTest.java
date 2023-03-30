package com.portx.dlovero.supplierRestClient.services;


import com.portx.dlovero.supplierRestClient.clients.PaymentHttpClient;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Test
    void testThatItCallsTheRightAmountOfTimes() {
        PaymentHttpClient mockedHttpClient = mock(PaymentHttpClient.class);
        PaymentService paymentService = new PaymentService(mockedHttpClient);
        paymentService.execute(10);

        verify(mockedHttpClient).sendPayments(argThat(payments -> payments.size() == 10));
    }
}