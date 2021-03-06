package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cin;
    private int pointFiabilite;

    public Client(long id, String cin, int pointFiabilite) {
        this.id = id;
        this.cin = cin;
        this.pointFiabilite = pointFiabilite;
    }

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public int getPointFiabilite() {
        return pointFiabilite;
    }

    public void setPointFiabilite(int pointFiabilite) {
        this.pointFiabilite = pointFiabilite;
    }
}
