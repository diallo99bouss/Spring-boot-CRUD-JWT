package sn.isi.Emploi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.Emploi.model.Cv;


@Repository
public interface CvDao extends JpaRepository<Cv, Integer> {
    Cv findByTelephone(String telephone);


}
