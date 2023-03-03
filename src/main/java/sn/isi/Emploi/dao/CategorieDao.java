package sn.isi.Emploi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.Emploi.model.Categorie;
@Repository

public interface CategorieDao extends JpaRepository<Categorie, Integer>  {
    Categorie findByLibelle(String libelle);

}
