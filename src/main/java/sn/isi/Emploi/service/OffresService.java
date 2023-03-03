package sn.isi.Emploi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.Emploi.dao.OffresDao;
import sn.isi.Emploi.model.Offres;

import java.util.List;
import java.util.Optional;

@Service
public class OffresService {
    @Autowired
    OffresDao offresDao;

    public Offres add(Offres offres) {
        return offresDao.save(offres);
    }

    public List<Offres> getAll()
    {
        return offresDao.findAll();
    }

    public Offres getOffres(Integer id) {
        Optional offreOpt = offresDao.findById(id);
        if (offreOpt.isPresent()) {
            return (Offres) offreOpt.get();
        } else { return null; }
    }

    public Offres update(Offres offres) { return offresDao.save(offres); }

    public Offres getByTitre(String titre) { return offresDao.findByTitre(titre); }

    public void  delete(Integer id) { offresDao.deleteById(id); }


}
