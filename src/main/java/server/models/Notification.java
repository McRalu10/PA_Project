package server.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID notificationID;
    private Date date;
    private String text;

    public Notification(String text) {
        new Notification();
        this.text = text;
    }

    public Notification() {
        this.date = new Date();
    }

    public UUID getNotificationID() {
        return notificationID;
    }


    public Date getDate() {
        return date;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
