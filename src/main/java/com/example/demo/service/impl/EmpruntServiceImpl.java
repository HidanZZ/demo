package com.example.demo.service.impl;

import com.example.demo.bean.Emprunt;
import com.example.demo.dao.EmpruntDao;
import com.example.demo.service.facade.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmpruntServiceImpl  implements EmpruntService {
    @Autowired
    private EmpruntDao empruntDao;

    @Override
    public List<Emprunt> findByLivreIsbn(String isbn) {
        return empruntDao.findByLivreIsbn(isbn);
    }

    @Override
    public List<Emprunt> findByClientCin(String cin) {
        return empruntDao.findByClientCin(cin);
    }

    @Override
    public List<Emprunt> findNonRestituee() {
        List<Emprunt> emprunts=empruntDao.findAll();
        List<Emprunt> empruntList=new ArrayList<Emprunt>();
        for (Emprunt emprunt:emprunts
             ) {
            if (emprunt.getDateRestitutionEffective()==null){
                empruntList.add(emprunt);
            }
        }
        return empruntList;
    }
}
