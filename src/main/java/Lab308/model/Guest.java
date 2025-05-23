package Lab308.model;


import jakarta.persistence.*;

@Entity
public class Guest{

    @Id
    String name;

    @Enumerated(EnumType.STRING)
    private GuestStatus guestStatus;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    //  Geters and Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuestStatus getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(GuestStatus guestStatus) {
        this.guestStatus = guestStatus;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    //Constructors
    //vacio


    public Guest() {
    }

    public Guest(String name, GuestStatus guestStatus) {
        this.name = name;
        this.guestStatus = guestStatus;
    }
}


