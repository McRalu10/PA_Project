package com.example.studenthotel.requests.POJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivitiesSearch {

    @SerializedName("accommodationID")
    @Expose
    private String accommodationID;
    @SerializedName("accommodationType")
    @Expose
    private String accommodationType;
    @SerializedName("serviceType")
    @Expose
    private Object serviceType;
    @SerializedName("price")
    @Expose
    private Object price;
    @SerializedName("free")
    @Expose
    private Boolean free;
    @SerializedName("capacity")
    @Expose
    private Integer capacity;
    @SerializedName("checkedIn")
    @Expose
    private Boolean checkedIn;
    @SerializedName("checkedOut")
    @Expose
    private Boolean checkedOut;
    @SerializedName("checkInDate")
    @Expose
    private Object checkInDate;
    @SerializedName("checkOutDate")
    @Expose
    private Object checkOutDate;
    @SerializedName("bookedDates")
    @Expose
    private BookedDates bookedDates;

    public String getAccommodationID() {
        return accommodationID;
    }

    public void setAccommodationID(String accommodationID) {
        this.accommodationID = accommodationID;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public Object getServiceType() {
        return serviceType;
    }

    public void setServiceType(Object serviceType) {
        this.serviceType = serviceType;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Object getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Object checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Object getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Object checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookedDates getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(BookedDates bookedDates) {
        this.bookedDates = bookedDates;
    }

}

class BookedDates {


}