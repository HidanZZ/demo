package com.example.demo.service.facade;

import com.example.demo.bean.Livre;

public interface LivreService {
    public Livre findByIsbn(String isbn);
}
