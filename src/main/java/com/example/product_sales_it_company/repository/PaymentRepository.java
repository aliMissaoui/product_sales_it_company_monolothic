package com.example.product_sales_it_company.repository;

import com.example.product_sales_it_company.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Payment query methods
    // Finding payments by amount
    List<Payment> findByAmount(double amount);
}
