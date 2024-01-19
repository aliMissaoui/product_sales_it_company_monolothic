package com.example.product_sales_it_company.repository;

import com.example.product_sales_it_company.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    // Client query methods
    List<Client> findByName(String name);

    List<Client> findByEmail(String email);
}
