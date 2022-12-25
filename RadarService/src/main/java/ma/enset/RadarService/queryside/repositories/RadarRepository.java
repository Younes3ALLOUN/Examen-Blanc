package ma.enset.RadarService.queryside.repositories;

import ma.enset.RadarService.queryside.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {
}
