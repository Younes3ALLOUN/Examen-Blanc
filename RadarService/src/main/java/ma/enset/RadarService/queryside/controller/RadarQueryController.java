package ma.enset.RadarService.queryside.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.RadarService.queryside.entities.Radar;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import queries.radar.GetAllRadarsQuery;
import queries.radar.GetRadarByIdQuery;

import java.util.List;

@RestController
@RequestMapping(path = "/queries/radar")
@AllArgsConstructor
@Slf4j
public class RadarQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/radars")
    public List<Radar> radarList(){
        List<Radar> radarList = queryGateway.query(new GetAllRadarsQuery(), ResponseTypes.multipleInstancesOf(Radar.class)).join();
        return  radarList;
    }

    @GetMapping("/radars/{radarid}")
    public Radar getRadar(@PathVariable String radarid){
        Radar radar = queryGateway.query(new GetRadarByIdQuery(radarid), ResponseTypes.instanceOf(Radar.class)).join();
        return  radar;
    }

}
