package ma.enset.immatriculationservice.queryside.controller;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.queryside.entities.Vehicule;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.vehicule.GetAllVehiculesQuery;
import queries.vehicule.GetVehiculeByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/queries/vehicule")
@AllArgsConstructor
public class VehiculeQueryController {

    private QueryGateway queryGateway;
    @GetMapping("/vehicules")
    public List<Vehicule> getallVehicules(){
        List<Vehicule> vehiculeList = queryGateway.query(new GetAllVehiculesQuery(), ResponseTypes.multipleInstancesOf(Vehicule.class)).join();
        return vehiculeList;
    }

    @GetMapping("/vehicules/{id}")
    public Vehicule getVehicule(@PathVariable String id){
        Vehicule vehicule = queryGateway.query(new GetVehiculeByIdQuery(id), ResponseTypes.instanceOf(Vehicule.class)).join();
        return vehicule;
    }

}
