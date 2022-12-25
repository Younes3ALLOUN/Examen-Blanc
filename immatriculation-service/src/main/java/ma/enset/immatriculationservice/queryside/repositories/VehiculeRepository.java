package ma.enset.immatriculationservice.queryside.repositories;


import ma.enset.immatriculationservice.queryside.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule,String> {
}
