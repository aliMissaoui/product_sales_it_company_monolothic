package com.example.product_sales_it_company.service;

import com.example.product_sales_it_company.model.Client;
import com.example.product_sales_it_company.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getClientsByName(String name) {
        return clientRepository.findByName(name);
    }

    public List<Client> getClientsByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(Long id, Client updatedClient) {
        Optional<Client> existingClient = clientRepository.findById(id);
        existingClient.ifPresent(client -> {
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            clientRepository.save(client);
        });
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
