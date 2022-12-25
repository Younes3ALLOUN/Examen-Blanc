package exceptions;

public class RadarIsNotExiste extends RuntimeException{
    public RadarIsNotExiste(String message) {
        super(message);
    }
}
