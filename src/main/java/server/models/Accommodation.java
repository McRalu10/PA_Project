package server.models;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "accommodations")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID accommodationID;
    private AccommodationType accommodationType;
    private ServiceType serviceType;
    @OneToOne
    private Price price;
    private boolean free;
    private int capacity;
    private boolean checkedIn;
    private boolean checkedOut;
    private Date checkInDate;
    private Date checkOutDate;

    public Accommodation(AccommodationType accommodationType) {
        new Accommodation();
        this.accommodationType = accommodationType;
        if (accommodationType == AccommodationType.APARTMENT) {
            this.capacity = 4;
        } else if (accommodationType == AccommodationType.SUITE) {
            this.capacity = 3;
        } else if (accommodationType == AccommodationType.DOUBLE) {
            this.capacity = 2;
        } else {
            this.capacity = 1;
        }
    }

    public Accommodation() {
        this.free = true;
        this.checkedIn = false;
        this.checkedOut = false;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
