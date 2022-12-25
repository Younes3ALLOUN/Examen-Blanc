package ma.enset.RadarService.queryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Radar {
    @Id
    private String id;
    private double vitesseMax;
    private double longitude;
    private double latitude;
}
