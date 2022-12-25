package ma.enset.immatriculationservice.queryside.service;

import events.owner.OwnerCreatedEvent;
import events.owner.OwnerUpdatedEvent;
import events.vehicule.VehiculeCreatedEvent;
import events.vehicule.VehiculeUpdatedEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.immatriculationservice.queryside.entities.Owner;
import ma.enset.immatriculationservice.queryside.entities.Vehicule;
import ma.enset.immatriculationservice.queryside.repositories.OwnerRepository;
import ma.enset.immatriculationservice.queryside.repositories.VehiculeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.owner.GetAllOwnerQuery;
import queries.owner.GetOwnerByIdQuery;
import queries.vehicule.GetAllVehiculesQuery;
import queries.vehicule.GetVehiculeByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ImmatriculationServiceHandler {
    private OwnerRepository ownerRepository;
    private VehiculeRepository vehiculeRepository;
    @EventHandler
    public void on(OwnerCreatedEvent event){
        Owner owner = new Owner();
        owner.setId(event.getId());
        owner.setName(event.getName());
        owner.setDat_naissance(event.getDat_naissance());
        owner.setEmail(event.getEmail());
        ownerRepository.save(owner);
    }

    @EventHandler
    public void on(OwnerUpdatedEvent event){
        Owner owner = ownerRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("the person with id :" + event.getId() + " is not existe"));
        if(event.getName()!=null)owner.setName(event.getName());
        if(event.getDat_naissance()!=null)owner.setDat_naissance(event.getDat_naissance());
        if(event.getEmail()!=null)owner.setEmail(event.getEmail());
        ownerRepository.save(owner);
    }
    @EventHandler
    public void on(VehiculeCreatedEvent event){
        Vehicule vehicule = new Vehicule();
        vehicule.setId(event.getId());
        vehicule.setMatricule(event.getMatricule());
        vehicule.setMarque(event.getMarque());
        vehicule.setModele(event.getModele());
        vehicule.setPuissance(event.getPuissance());
        if (event.getOwnerid()!=null){
            Owner owner = ownerRepository.findById(event.getOwnerid()).orElseThrow(() -> new RuntimeException("the person with id :" + event.getOwnerid() + " is not existe"));
            vehicule.setOwner(owner);
        }
        vehiculeRepository.save(vehicule);
    }
    @EventHandler
    public void on(VehiculeUpdatedEvent event){
        Vehicule vehicule = vehiculeRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("the Vehicule with id :" + event.getId() + " is not existe"));
        if (event.getMatricule()!=null)vehicule.setMatricule(event.getMatricule());
        if (event.getMarque()!=null)vehicule.setMarque(event.getMarque());
        if (event.getModele()!=null)vehicule.setModele(event.getModele());
        if (event.getPuissance()>0){
            vehicule.setPuissance(event.getPuissance());
        }else throw new RuntimeException("puissance can not be equal or less than 0");

        if (event.getOwnerid()!=null){
            Owner owner = ownerRepository.findById(event.getOwnerid()).orElseThrow(() -> new RuntimeException("the person with id :" + event.getId() + " is not existe"));
            vehicule.setOwner(owner);
        }
        vehiculeRepository.save(vehicule);
    }
    @QueryHandler
    public List<Owner> on(GetAllOwnerQuery query){
        return ownerRepository.findAll();
    }
    @QueryHandler
    public Owner on(GetOwnerByIdQuery query){
        Owner owner = ownerRepository.findById(query.getOwnerid()).orElseThrow(() -> new RuntimeException("the person with id :" + query.getOwnerid() + " is not existe"));
        return owner;
    }
      @QueryHandler
    public List<Vehicule> on(GetAllVehiculesQuery query){
        return vehiculeRepository.findAll();
    }
    @QueryHandler
    public Vehicule on(GetVehiculeByIdQuery query){
        Vehicule vehicule = vehiculeRepository.findById(query.getVehiculeid()).orElseThrow(() -> new RuntimeException("the vegicule with id :" + query.getVehiculeid() + " is not existe"));
        return vehicule;
    }
}
