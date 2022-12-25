package events;

import lombok.Getter;

public abstract class BaseEvent <T>{
    public BaseEvent(T id) {
        this.id = id;
    }

    @Getter private T id;
}
