package events.vehicule;

import commands.BaseCommand;
import events.BaseEvent;
import lombok.Getter;

@Getter
public class VehiculeCreatedEvent extends BaseEvent<String> {

    private String matricule;
    private String marque;
    private String modele;
    private double puissance;
    private String ownerid;

    public VehiculeCreatedEvent(String id, String matricule, String marque, String modele, double puissance, String ownerid) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.ownerid = ownerid;
    }
}
