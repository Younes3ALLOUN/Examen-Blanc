package ma.enset.RadarService.queryside.service;

import events.radar.RadarCreatedEvent;
import events.radar.RadarUpdatedEvent;
import exceptions.RadarIsNotExiste;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.RadarService.queryside.entities.Radar;
import ma.enset.RadarService.queryside.repositories.RadarRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import queries.radar.GetAllRadarsQuery;
import queries.radar.GetRadarByIdQuery;

import java.util.List;

@Service
@AllArgsConstructor @Slf4j
public class RadarServiceHandler {
    private RadarRepository radarRepository;
    @EventHandler
    public void on(RadarCreatedEvent event){
        log.info("<==============> created event recieved to query side");
        System.out.println(event.getVitesseMax());
        Radar radar=new Radar();
        radar.setId(event.getId());
        radar.setLongitude(event.getLongitude());
        radar.setVitesseMax(event.getVitesseMax());
        radar.setLatitude(event.getLatitude());

        radarRepository.save(radar);
    }
    @EventHandler
    public void on(RadarUpdatedEvent event){
        Radar radar = radarRepository.findById(event.getId()).orElseThrow(() -> new RadarIsNotExiste(" radar with id " + event.getId() + " is not existe"));
            radar.setVitesseMax(event.getVitesseMax());
            radar.setLatitude(event.getLatitude());
            radar.setLongitude(event.getLongitude());
            radarRepository.save(radar);
    }
    @QueryHandler
    public List<Radar> on(GetAllRadarsQuery query){
        List<Radar> radarList = radarRepository.findAll();
        return  radarList;
    }

    @QueryHandler
    public Radar on(GetRadarByIdQuery query){
        Radar radar = radarRepository.findById(query.getRadarid()).orElseThrow(() -> new RadarIsNotExiste(" radar with id " + query.getRadarid() + " is not existe"));
        return radar;
    }
}
