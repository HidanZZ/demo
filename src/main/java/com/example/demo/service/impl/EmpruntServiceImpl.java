package com.example.demo.service.impl;

import com.example.demo.bean.Emprunt;
import com.example.demo.dao.EmpruntDao;
import com.example.demo.service.facade.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class EmpruntServiceImpl  implements EmpruntService{
    @Autowired
    private EmpruntDao empruntDao;
    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private  LivreServiceImpl livreService;


    @Override
    public  Emprunt findById(Long id) {
        return empruntDao.findById(id).orElse(null);
    }

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

    @Override
    public int save(Emprunt emprunt) {
        if (clientService.findBycin(emprunt.getClient().getCin())==null){
            return -1;
        }else if (clientService.findNonFiableCLients().contains(emprunt.getClient())){
            return -2;
        }else if (livreService.findByIsbn(emprunt.getLivre().getIsbn())==null){
            return -3;
        }else if (emprunt.getLivre().getNbrExemplaire()==0){
            return -4;
        }else{
            Date actualtime=new Date();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(actualtime);
            calendar.add(Calendar.DATE,emprunt.getLivre().getNbrJourEmprunt());
            Date dateDeRestitution=calendar.getTime();

            emprunt.setDateEmprunt(actualtime);
            emprunt.setDateRestitutionPrevu(dateDeRestitution);
            empruntDao.save(emprunt);
            return 1;
        }
    }

    @Override
    public int restituer(Long idEmprunt, Date dateRestitution) {
            if (findById(idEmprunt)==null){
                return -1;
            }else if (findById(idEmprunt).getDateRestitutionEffective()!=null){
                return -2;
            }else{
                Emprunt emprunt=findById(idEmprunt);
                emprunt.setDateRestitutionEffective(dateRestitution);
                int diff= (int) ((dateRestitution.getTime()-emprunt.getDateEmprunt().getTime())/(1000*60*60*24));
                emprunt.getClient().setPointFiabilite(emprunt.getClient().getPointFiabilite()-diff);
                emprunt.getLivre().setNbrExemplaire(emprunt.getLivre().getNbrExemplaire()+1);
                empruntDao.save(emprunt);
                return 1;

            }
    }

}
