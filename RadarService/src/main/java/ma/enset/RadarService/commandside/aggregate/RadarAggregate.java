package ma.enset.RadarService.commandside.aggregate;

import commands.radar.RadarCreateCommand;
import commands.radar.RadarUpdateCommand;
import events.radar.RadarCreatedEvent;
import events.radar.RadarUpdatedEvent;
import exceptions.EntryNegativeException;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class RadarAggregate {
    @AggregateIdentifier
    private String id;
    private double vitesseMax;
    private double longitude;
    private double latitude;

    public RadarAggregate() {
    }
    @CommandHandler
    public RadarAggregate(RadarCreateCommand command) {
        log.info("========= command received");
        //System.out.println(command.getVitesseMax());
        if(command.getVitesseMax()<0)throw new EntryNegativeException("speed should not be negatif");
        AggregateLifecycle.apply(new RadarCreatedEvent(
                command.getId(),
                command.getVitesseMax(),
                command.getLongitude(), command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on(RadarCreatedEvent event){
        log.info("========= event received");
        this.id=event.getId();
        this.latitude= event.getLatitude();
        this.longitude= event.getLongitude();
        this.vitesseMax=event.getVitesseMax();
    }

    @CommandHandler
    public void updateHandler(RadarUpdateCommand command) {
        log.info("========= command received");
        //System.out.println(command.getVitesseMax());
        if(command.getVitesseMax()<0)throw new EntryNegativeException("speed should not be negatif");
        AggregateLifecycle.apply(new RadarUpdatedEvent(
                command.getId(),
                command.getVitesseMax(),
                command.getLongitude(), command.getLatitude()
        ));
    }
    @EventSourcingHandler
    public void on(RadarUpdatedEvent event){
        log.info("========= event received");
        this.latitude= event.getLatitude();
        this.longitude= event.getLongitude();
        this.vitesseMax=event.getVitesseMax();
    }

}
