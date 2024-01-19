package com.example.product_sales_it_company.controller;

import com.example.product_sales_it_company.model.Payment;
import com.example.product_sales_it_company.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public String getAllPayments(Model model) {
        List<Payment> payments = paymentService.getAllPayments();
        model.addAttribute("payments", payments);
        return "payments";
    }

    @GetMapping("/{id}")
    public String getPaymentById(@PathVariable Long id, Model model) {
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "paymentDetails";
    }

    @GetMapping("/new")
    public String showPaymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        return "newPayment";
    }

    @PostMapping("/new")
    public String addNewPayment(@ModelAttribute Payment payment) {
        paymentService.addPayment(payment);
        return "redirect:/payments/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "editPayment";
    }

    @PostMapping("/edit/{id}")
    public String updatePayment(@PathVariable Long id, @ModelAttribute Payment updatedPayment) {
        paymentService.updatePayment(id, updatedPayment);
        return "redirect:/payments/";
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "redirect:/payments/";
    }
}
