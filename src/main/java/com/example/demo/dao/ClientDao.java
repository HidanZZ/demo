package com.example.demo.dao;

import com.example.demo.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
    public Client findByCin(String cin);
    public List<Client> findByPointFiabiliteIsLessThan(int pointFiabilite);
}
