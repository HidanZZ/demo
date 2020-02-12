package com.example.demo.service.impl;

import com.example.demo.bean.Client;
import com.example.demo.dao.ClientDao;
import com.example.demo.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public Client findBycin(String cin) {
        return clientDao.findByCin(cin);
    }

    @Override
    public List<Client> findByPointFiabiliteLessThan(int pointFiabilite) {
        return clientDao.findByPointFiabiliteIsLessThan(pointFiabilite);
    }

    @Override
    public List<Client> findNonFiableCLients() {
        return findByPointFiabiliteLessThan(5);
    }


}
