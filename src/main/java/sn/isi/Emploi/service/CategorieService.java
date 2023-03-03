package sn.isi.Emploi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.Emploi.dao.CategorieDao;
import sn.isi.Emploi.dao.OffresDao;
import sn.isi.Emploi.model.Categorie;
import sn.isi.Emploi.model.Offres;

import java.util.List;
import java.util.Optional;
@Service

public class CategorieService {
    @Autowired
    CategorieDao categorieDao;

    public Categorie add(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    public List<Categorie> getAll()
    {
        return categorieDao.findAll();
    }

    public Categorie getCategorie(Integer id) {
        Optional CatOpt = categorieDao.findById(id);
        if (CatOpt.isPresent()) {
            return (Categorie) CatOpt.get();
        } else { return null; }
    }

    public Categorie update(Categorie categorie) { return categorieDao.save(categorie); }

    public Categorie getByLibelle(String libelle) { return categorieDao.findByLibelle(libelle); }

    public void  delete(Integer id) { categorieDao.deleteById(id); }

}
