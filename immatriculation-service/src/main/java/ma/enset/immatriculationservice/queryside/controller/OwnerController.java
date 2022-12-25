package ma.enset.immatriculationservice.queryside.controller;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.queryside.entities.Owner;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.owner.GetAllOwnerQuery;
import queries.owner.GetOwnerByIdQuery;
import queries.radar.GetRadarByIdQuery;

import java.util.List;

@RestController
@RequestMapping("/queries/owner") @AllArgsConstructor
public class OwnerController {
    QueryGateway queryGateway;
    @GetMapping("/owners")
    public List<Owner> getAllOwners(){
        List<Owner> ownerList = queryGateway.query(new GetAllOwnerQuery(), ResponseTypes.multipleInstancesOf(Owner.class)).join();
        return ownerList;
    }

    @GetMapping("/owners/{ownerid}")
    public Owner getRadar(@PathVariable String ownerid){
        Owner owner = queryGateway.query(new GetOwnerByIdQuery(ownerid), ResponseTypes.instanceOf(Owner.class)).join();
        return  owner;
    }
}
