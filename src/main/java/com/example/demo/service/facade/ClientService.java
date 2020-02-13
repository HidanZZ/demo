package com.example.demo.service.facade;

import com.example.demo.bean.Client;

import java.util.List;

public interface ClientService {
    public Client findBycin(String cin);
    public List<Client> findByPointFiabiliteLessThan(int pointFiabilite);
    public List<Client> findNonFiableCLients();
    public int save(Client client);
}
