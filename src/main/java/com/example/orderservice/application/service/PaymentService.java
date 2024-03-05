package com.example.orderservice.application.service;

import com.example.orderservice.domain.entity.payment.Payment;
import com.example.orderservice.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Optional<List<Payment>> listPayments() {
        return Optional.of(paymentRepository.findAll());
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment costumer) {
        return paymentRepository.save(costumer);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> existingPaymentOptional = paymentRepository.findById(id);
        if (existingPaymentOptional.isPresent()) {
            Payment existingPayment = existingPaymentOptional.get();
            existingPayment.setName(updatedPayment.getName());
            existingPayment.setEmail(updatedPayment.getEmail());
            // Atualize outros campos conforme necessário
            return paymentRepository.save(existingPayment);
        } else {
            // Lide com a lógica de erro aqui, se necessário
            return null;
        }
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
