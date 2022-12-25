package commands.vehicule;

import commands.BaseCommand;
import lombok.Getter;

@Getter
public class VehiculeCreateCommand extends BaseCommand<String> {

    private String matricule;
    private String marque;
    private String modele;
    private double puissance;
    private String ownerid;

    public VehiculeCreateCommand(String id, String matricule, String marque, String modele, double puissance, String ownerid) {
        super(id);
        this.matricule = matricule;
        this.marque = marque;
        this.modele = modele;
        this.puissance = puissance;
        this.ownerid = ownerid;
    }
}
