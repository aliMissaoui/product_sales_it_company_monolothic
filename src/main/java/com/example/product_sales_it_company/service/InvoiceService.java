package com.example.product_sales_it_company.service;

import com.example.product_sales_it_company.model.Invoice;
import com.example.product_sales_it_company.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    public List<Invoice> getInvoicesByDate(Date date) {
        return invoiceRepository.findByDate(date);
    }

    public void addInvoice(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Long id, Invoice updatedInvoice) {
        Optional<Invoice> existingInvoice = invoiceRepository.findById(id);
        existingInvoice.ifPresent(invoice -> {
            invoice.setDate(updatedInvoice.getDate());
            invoiceRepository.save(invoice);
        });
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
