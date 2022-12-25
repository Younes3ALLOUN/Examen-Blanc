package events.owner;


import events.BaseEvent;
import lombok.Getter;

import java.util.Date;

@Getter
public class OwnerUpdatedEvent extends BaseEvent<String> {
    private String name;
    private Date dat_naissance;
    private String email;

    public OwnerUpdatedEvent(String id, String name, Date datNaissance, String email) {
        super(id);
        this.name = name;
        this.dat_naissance = datNaissance;
        this.email = email;
    }
}
