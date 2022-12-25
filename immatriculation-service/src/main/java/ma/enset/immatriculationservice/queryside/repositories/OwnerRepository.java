package ma.enset.immatriculationservice.queryside.repositories;

import ma.enset.immatriculationservice.queryside.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}
