package server.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID activityID;
    private Date date;
    private int duration;
    private String title;
    private String description;
    private Double price;
    @OneToMany
    private List<User> participants;

    public Activity(Date date, int duration, String title, String description, Double price) {
        new Activity();
        this.date = date;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Activity() {
        this.participants = new ArrayList<>();
    }

    public UUID getActivityID() {
        return activityID;
    }

    public void setActivityID(UUID activityID) {
        this.activityID = activityID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public Double getPrice() {
        return price;
    }
}
