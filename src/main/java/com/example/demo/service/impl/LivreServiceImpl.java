package com.example.demo.service.impl;

import com.example.demo.bean.Livre;
import com.example.demo.dao.LivreDao;
import com.example.demo.service.facade.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivreServiceImpl implements LivreService {
    @Autowired
    private LivreDao livreDao;


    @Override
    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }
}
