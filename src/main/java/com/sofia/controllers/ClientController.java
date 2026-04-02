package com.sofia.controllers;

import com.sofia.model.Client;
import com.sofia.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        Client savedClient = service.create(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = service.findAll();
        return ResponseEntity.ok(clients);
    }

}
