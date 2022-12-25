package queries.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor  @AllArgsConstructor
public class GetRadarByIdQuery {
    private String radarid;
}
