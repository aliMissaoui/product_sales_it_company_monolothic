package com.example.product_sales_it_company.controller;

import com.example.product_sales_it_company.model.Invoice;
import com.example.product_sales_it_company.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public String getAllInvoices(Model model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/{id}")
    public String getInvoiceById(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "invoiceDetails";
    }

    @GetMapping("/new")
    public String showInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "newInvoice";
    }

    @PostMapping("/new")
    public String addNewInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.addInvoice(invoice);
        return "redirect:/invoices/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "editInvoice";
    }

    @PostMapping("/edit/{id}")
    public String updateInvoice(@PathVariable Long id, @ModelAttribute Invoice updatedInvoice) {
        invoiceService.updateInvoice(id, updatedInvoice);
        return "redirect:/invoices/";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/invoices/";
    }
}
