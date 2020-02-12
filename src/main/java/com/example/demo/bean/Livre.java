package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String titre;
    private int nbrExemplaire;
    private int nbrJourEmprunt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNbrExemplaire() {
        return nbrExemplaire;
    }

    public void setNbrExemplaire(int nbrExemplaire) {
        this.nbrExemplaire = nbrExemplaire;
    }

    public int getNbrJourEmprunt() {
        return nbrJourEmprunt;
    }

    public void setNbrJourEmprunt(int nbrJourEmprunt) {
        this.nbrJourEmprunt = nbrJourEmprunt;
    }


    public Livre(long id,String isbn,String titre,int nbrExemplaire,int nbrJourEmprunt) {
        this.id=id;
        this.isbn=isbn;
        this.titre=titre;
        this.nbrExemplaire=nbrExemplaire;
        this.nbrJourEmprunt=nbrJourEmprunt;
    }

    public Livre() {
    }
}
