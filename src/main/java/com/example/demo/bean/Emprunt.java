package com.example.demo.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Livre livre;
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateRestitutionEffective;
    @ManyToOne
    private Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRestitutionPrevu() {
        return dateRestitutionPrevu;
    }

    public void setDateRestitutionPrevu(Date dateRestitutionPrevu) {
        this.dateRestitutionPrevu = dateRestitutionPrevu;
    }

    public Date getDateRestitutionEffective() {
        return dateRestitutionEffective;
    }

    public void setDateRestitutionEffective(Date dateRestitutionEffective) {
        this.dateRestitutionEffective = dateRestitutionEffective;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Emprunt(long id,Livre livre,Client client) {
        this.id=id;
        this.livre=livre;
        this.dateEmprunt=new Date();
        this.dateRestitutionEffective=null;
        this.dateRestitutionPrevu=null;
        this.client=client;
    }

    public Emprunt() {
    }
}
