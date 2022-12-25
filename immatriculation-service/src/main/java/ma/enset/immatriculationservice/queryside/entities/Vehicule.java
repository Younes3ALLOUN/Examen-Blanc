package ma.enset.immatriculationservice.queryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Vehicule {
    @Id
    private String id;
    private String matricule;
    private String marque;
    private String modele;
    private double puissance;
    @ManyToOne
    private Owner owner;
}
