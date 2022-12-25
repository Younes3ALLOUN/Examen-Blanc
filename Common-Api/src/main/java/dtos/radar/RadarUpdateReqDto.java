package dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RadarUpdateReqDto {
    private String id;
    private double vitesseMax;
    private double longitude;
     private double latitude;
}
