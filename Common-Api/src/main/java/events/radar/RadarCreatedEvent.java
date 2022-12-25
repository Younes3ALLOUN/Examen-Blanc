package events.radar;

import events.BaseEvent;
import lombok.Getter;

public class RadarCreatedEvent extends BaseEvent <String> {
    @Getter
    private double vitesseMax;
    @Getter private double longitude;
    @Getter private double latitude;
    public RadarCreatedEvent(String id, double vitesseMax, double longitude, double latitude) {
        super(id);
        this.vitesseMax = vitesseMax;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
