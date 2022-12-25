package queries.vehicule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @NoArgsConstructor  @AllArgsConstructor
public class GetVehiculeByIdQuery {
    private String vehiculeid;
}
