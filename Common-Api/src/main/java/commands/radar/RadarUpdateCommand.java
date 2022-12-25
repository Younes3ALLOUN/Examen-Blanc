package commands.radar;

import commands.BaseCommand;
import lombok.Getter;

public class RadarUpdateCommand extends BaseCommand<String> {
    @Getter private double vitesseMax;
    @Getter private double longitude;
    @Getter private double latitude;
    public RadarUpdateCommand(String id, double vitesseMax, double longitude, double latitude) {
        super(id);
        this.vitesseMax = vitesseMax;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
