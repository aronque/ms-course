package org.example.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.entities.Payment;
import org.example.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentByWorkerIdAlternative")
    @GetMapping(value = "/{id}/days/{days}")
    public ResponseEntity<Payment> getPaymentByWorkerId(@PathVariable Long id, @PathVariable Integer days) {
        Payment payment = service.getPayment(id, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentByWorkerIdAlternative(Long id, Integer days) {
        Payment payment = new Payment("Nometeste", 400.0, days);
        return ResponseEntity.ok(payment);
    }

}
