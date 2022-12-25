package dtos.vehicule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class VehiculeUpdateReqDto {
    private  String id;
    private String matricule;
    private String marque;
    private String modele;
    private double puissance;
    private String ownerid;
}
