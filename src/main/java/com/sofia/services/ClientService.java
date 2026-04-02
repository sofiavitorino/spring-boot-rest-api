package com.sofia.services;

import com.sofia.model.Client;
import com.sofia.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
