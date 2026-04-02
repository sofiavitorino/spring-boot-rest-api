package com.sofia.services;

import com.sofia.model.Client;
import com.sofia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(Client client) {
        return repository.save(client);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    public Client update(Integer id, Client client) {
        Client existingClient = repository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        existingClient.setFirstName(client.getFirstName());
        existingClient.setLastName(client.getLastName());
        existingClient.setCountry(client.getCountry());
        existingClient.setGender(client.getGender());
        return repository.save(existingClient);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Client not found.");
        }
        repository.deleteById(id);
    }
}
