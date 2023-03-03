package sn.isi.Emploi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offres {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String email;
    @NotNull
    private String titre;
    @NotNull
    private String adresse;
    @NotNull
    private String type;
    @NotNull
    private String description;
    @NotNull
    private String companyName;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;
}
