package server.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID messageID;
    private UUID senderID;
    private Date date;
    private String text;

    public Message(UUID senderID, String text) {
        new Message();
        this.senderID = senderID;
        this.text = text;
    }

    public Message() {
        this.date = new Date();
    }

    public UUID getMessageID() {
        return messageID;
    }


    public UUID getSenderID() {
        return senderID;
    }

    public void setSenderID(UUID senderID) {
        this.senderID = senderID;
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
