package sn.isi.Emploi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.Emploi.model.Cv;
import sn.isi.Emploi.model.Offres;
@Repository

public interface OffresDao extends JpaRepository<Offres, Integer> {
    Offres findByTitre(String titre);

}
