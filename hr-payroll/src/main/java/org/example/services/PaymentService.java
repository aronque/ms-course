package org.example.services;

import org.example.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Teste1", 49000.0, days);
    }
}
