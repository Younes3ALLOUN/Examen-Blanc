package ma.enset.immatriculationservice.commandside.aggregate;

import commands.owner.OwnerCreateCommand;
import commands.owner.OwnerUpdateCommand;
import events.owner.OwnerCreatedEvent;
import events.owner.OwnerUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@Aggregate
@Slf4j
public class OwnerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private Date dat_naissance;
    private String email;

    public OwnerAggregate() {
    }
@CommandHandler
    public OwnerAggregate(OwnerCreateCommand command) {
        AggregateLifecycle.apply(new OwnerCreatedEvent(
                command.getId(), command.getName(), command.getDat_naissance(), command.getEmail()
        ));
    }
    @EventSourcingHandler
    public void on(OwnerCreatedEvent event){
        this.id=event.getId();
        this.name= event.getName();
        this.dat_naissance=event.getDat_naissance();
        this.email = event.getEmail();

    }
    @CommandHandler
    public void hundle(OwnerUpdateCommand command){
        AggregateLifecycle.apply(new OwnerUpdatedEvent(
                command.getId(), command.getName(), command.getDat_naissance(), command.getEmail()
        ));
    }
    @EventSourcingHandler
    public void on(OwnerUpdatedEvent event){
        this.name= event.getName();
        this.dat_naissance=event.getDat_naissance();
        this.email = event.getEmail();

    }
}
