package com.example.product_sales_it_company.service;

import com.example.product_sales_it_company.model.Payment;
import com.example.product_sales_it_company.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByAmount(double amount) {
        return paymentRepository.findByAmount(amount);
    }

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void updatePayment(Long id, Payment updatedPayment) {
        Optional<Payment> existingPayment = paymentRepository.findById(id);
        existingPayment.ifPresent(payment -> {
            payment.setAmount(updatedPayment.getAmount());
            payment.setDate(updatedPayment.getDate());
            paymentRepository.save(payment);
        });
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
