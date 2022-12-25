package ma.enset.immatriculationservice.commandside.aggregate;

import commands.vehicule.VehiculeCreateCommand;
import commands.vehicule.VehiculeUpdateCommand;
import events.vehicule.VehiculeCreatedEvent;
import events.vehicule.VehiculeUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class VehiculeAggregate {
    @AggregateIdentifier
    private String id;
    private String matricule;
    private String marque;
    private String modele;
    private double puissance;
    private String ownerid;



    public VehiculeAggregate() {
    }
    @CommandHandler
    public VehiculeAggregate(VehiculeCreateCommand command) {

        AggregateLifecycle.apply(new VehiculeCreatedEvent(
                command.getId(), command.getMatricule(), command.getMarque(), command.getModele(), command.getPuissance(), command.getOwnerid()
        ));
    }
    @EventSourcingHandler
    public void on(VehiculeCreatedEvent event){
        this.id= event.getId();
        this.matricule = event.getMatricule();
        this.marque = event.getMarque();
        this.modele = event.getModele();
        this.puissance = event.getPuissance();
        this.ownerid = event.getOwnerid();
    }
    @CommandHandler
    public void handler(VehiculeUpdateCommand command){
        AggregateLifecycle.apply(new VehiculeUpdatedEvent(
                command.getId(), command.getMatricule(), command.getMarque(), command.getModele(), command.getPuissance(), command.getOwnerid()
        ));
    }

    @EventSourcingHandler
    public void on(VehiculeUpdatedEvent event){
        this.matricule = event.getMatricule();
        this.marque = event.getMarque();
        this.modele = event.getModele();
        this.puissance = event.getPuissance();
        this.ownerid = event.getOwnerid();
    }

}
