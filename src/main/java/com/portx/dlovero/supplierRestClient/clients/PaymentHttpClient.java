package com.portx.dlovero.supplierRestClient.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portx.dlovero.supplierRestClient.domain.model.Payment;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
public class PaymentHttpClient implements PaymentClient {

    public static final String PAYMENTS_ENDPOINT = "/payments";
    @Value("${paymentsRestApi.endpoint}")
    private String paymentsEndpoint;

    private final CloseableHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public PaymentHttpClient() {
        this.httpClient = HttpClients.createDefault();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void sendPayments(List<Payment> payments) {
        System.out.println("Starting to send payments...");
        for (Payment payment : payments) {
            HttpPost post = new HttpPost(paymentsEndpoint + PAYMENTS_ENDPOINT);
            post.setHeader("Content-Type", "application/json");
            String idempotentKey = UUID.randomUUID().toString();
            post.setHeader("idempotent-key", idempotentKey);

            try {
                String json = objectMapper.writeValueAsString(payment);
                post.setEntity(new StringEntity(json));

                CloseableHttpResponse response = httpClient.execute(post);
                response.close();
            } catch (IOException e) {
                System.out.println("Could not send payment with idempotent key: " + idempotentKey);
                e.printStackTrace();
            }
        }

        System.out.println("Payments sent!");
    }
}
