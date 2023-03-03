package sn.isi.Emploi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.Emploi.dao.CvDao;
import sn.isi.Emploi.model.Cv;


import java.util.List;
import java.util.Optional;

@Service
public class CvService {
    @Autowired
    CvDao cvDao;

    public Cv add(Cv cv) {
        return cvDao.save(cv);
    }

    public List<Cv> getAll()
    {
        return cvDao.findAll();
    }

    public Cv getCv(Integer id) {
        Optional cvOpt = cvDao.findById(id);
        if (cvOpt.isPresent()) {
            return (Cv) cvOpt.get();
        } else { return null; }
    }

    public Cv update(Cv cv) { return cvDao.save(cv); }

    public Cv getByTelephone(String telephone) { return cvDao.findByTelephone(telephone); }
    
    public void  delete(Integer id) { cvDao.deleteById(id); }



}
