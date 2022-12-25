package dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RadarReqDto {
    private double vitesseMax;
    private double longitude;
     private double latitude;
}
