package events.owner;

import commands.BaseCommand;
import events.BaseEvent;
import lombok.Getter;

import java.util.Date;

@Getter
public class OwnerCreatedEvent extends BaseEvent<String> {
    private String name;
    private Date dat_naissance;
    private String email;

    public OwnerCreatedEvent(String id, String name, Date datNaissance, String email) {
        super(id);
        this.name = name;
        this.dat_naissance = datNaissance;
        this.email = email;
    }
}
