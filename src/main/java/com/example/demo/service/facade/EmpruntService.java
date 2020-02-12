package com.example.demo.service.facade;

import com.example.demo.bean.Client;
import com.example.demo.bean.Emprunt;

import java.util.List;

public interface EmpruntService {
    public List<Emprunt> findByLivreIsbn(String isbn);
    public List<Emprunt> findByClientCin(String cin);
    public List<Emprunt> findNonRestituee();
}
