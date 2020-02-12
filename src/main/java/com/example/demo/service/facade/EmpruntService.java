package com.example.demo.service.facade;

import com.example.demo.bean.Client;
import com.example.demo.bean.Emprunt;

import java.util.Date;
import java.util.List;

public interface EmpruntService {
    public Emprunt findById(Long id);
    public List<Emprunt> findByLivreIsbn(String isbn);
    public List<Emprunt> findByClientCin(String cin);
    public List<Emprunt> findNonRestituee();
    public int save(Emprunt emprunt);
    public int restituer(Long idEmprunt, Date dateRestitution);
}
