package com.example.studenthotel.requests.POJO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("receivedMessages")
    @Expose
    private List<Object> receivedMessages = null;
    @SerializedName("notifications")
    @Expose
    private List<Object> notifications = null;
    @SerializedName("accommodation")
    @Expose
    private Object accommodation;
    @SerializedName("logged")
    @Expose
    private Boolean logged;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Object> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Object> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Object> notifications) {
        this.notifications = notifications;
    }

    public Object getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Object accommodation) {
        this.accommodation = accommodation;
    }

    public Boolean getLogged() {
        return logged;
    }

    public void setLogged(Boolean logged) {
        this.logged = logged;
    }

}