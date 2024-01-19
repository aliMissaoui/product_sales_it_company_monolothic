package com.example.product_sales_it_company.repository;

import com.example.product_sales_it_company.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // Invoice query methods
    // Finding invoices by date
    List<Invoice> findByDate(Date date);
}
