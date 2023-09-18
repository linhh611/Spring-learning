package app;

import org.springframework.context.ApplicationEvent;

public class DoorBellEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */

    String guestName;
    public DoorBellEvent(Object source, String currentGuestName) {
        super(source);
        this.guestName = currentGuestName;
    }

    public String getGuestName() {
        return guestName;
    }
}
