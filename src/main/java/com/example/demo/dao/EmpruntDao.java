package com.example.demo.dao;

import com.example.demo.bean.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpruntDao extends JpaRepository<Emprunt,Long> {
    public List<Emprunt> findByLivreIsbn(String isbn);
    public  List<Emprunt> findByClientCin(String cin);
    public List<Emprunt> findAll();
}
