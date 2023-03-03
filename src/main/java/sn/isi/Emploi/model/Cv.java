package sn.isi.Emploi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cv implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private Integer age;
    @NotNull
    private String adresse;
    @NotNull
//    @Digits(integer = 9, fraction = 0, message = "Phone number should have exactly 10 characters")
    private String telephone;
    @NotNull
    private String specialite;
    @NotNull
    private String niveauEetude;
    @NotNull
    private String experienceProfessionnelle;
    
   // private List<RegleGroupe> regleGroups = new ArrayList<RegleGroupe>();
    //private List<Activity> activities = new ArrayList<Activity>();
   // private List<Cotisation> cotisations = new ArrayList<Cotisation>();

//    @OneToMany
//    private List<Cotisation> cotisationList = new ArrayList<>();


}