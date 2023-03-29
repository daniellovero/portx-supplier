package com.portx.dlovero.supplierRestClient;

import com.portx.dlovero.supplierRestClient.services.PaymentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class SupplierRestClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierRestClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(PaymentService paymentService) {
        System.out.println("How many requests should I send? (int value)");
        Scanner scanner = new Scanner(System.in);
        int rawTimes;
        do {
            System.out.print("Enter the number of payments to send (must be an integer >= 1): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer greater than one.");
                scanner.next();
            }
            rawTimes = scanner.nextInt();
        } while (rawTimes < 1);

        // To be used by lambda
        int times = rawTimes;
        return (args) -> {
            paymentService.execute(times);
        };
    }
}
