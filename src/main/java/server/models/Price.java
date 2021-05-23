package server.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID priceID;
    private Double roomPrice;
    private Double mealsPrice;

    /**
     * price per room/night
     */
    private final static Double STUDENT_HOTEL_SINGLE_PRICE = 100D;
    private final static Double STUDENT_HOTEL_DOUBLE_PRICE = 150D;
    private final static Double STUDENT_HOTEL_APARTMENT_PRICE = 200D;
    private final static Double STUDENT_HOTEL_SUITE_PRICE = 175D;

    /**
     * price per room/night for a stay over a month
     */
    private final static Double STUDENT_EXTENDED_SINGLE_PRICE = 30D;
    private final static Double STUDENT_EXTENDED_DOUBLE_PRICE = 50D;
    private final static Double STUDENT_EXTENDED_APARTMENT_PRICE = 80D;
    private final static Double STUDENT_EXTENDED_SUITE_PRICE = 75D;

    /**
     * price per person/night for a stay over a month
     */
    private final static Double STUDENT_EXTENDED_BASIC_DOUBLE_PRICE = 25D;
    private final static Double STUDENT_EXTENDED_BASIC_APARTMENT_PRICE = 20D;
    private final static Double STUDENT_EXTENDED_BASIC_SUITE_PRICE = 23D;

    /**
     * price per room/night
     */
    private final static Double OTHER_HOTEL_SINGLE_PRICE = 150D;
    private final static Double OTHER_HOTEL_DOUBLE_PRICE = 200D;
    private final static Double OTHER_HOTEL_APARTMENT_PRICE = 250D;
    private final static Double OTHER_HOTEL_SUITE_PRICE = 225D;

    /**
     * price per room/night for a stay over a month
     */
    private final static Double OTHER_EXTENDED_SINGLE_PRICE = 50D;
    private final static Double OTHER_EXTENDED_DOUBLE_PRICE = 80D;
    private final static Double OTHER_EXTENDED_APARTMENT_PRICE = 120D;
    private final static Double OTHER_EXTENDED_SUITE_PRICE = 90D;

    /**
     * price per person/night for a stay over a month
     */
    private final static Double OTHER_EXTENDED_BASIC_DOUBLE_PRICE = 40D;
    private final static Double OTHER_EXTENDED_BASIC_APARTMENT_PRICE = 30D;
    private final static Double OTHER_EXTENDED_BASIC_SUITE_PRICE = 30D;

    /**
     * price for meals/day
     */
    private final static Double STUDENT_MEALS_PRICE = 20.25;
    private final static Double OTHER_MEALS_PRICE = 35D;

    public UUID getPriceID() {
        return priceID;
    }

    public Double getRoomPrice() {
        return roomPrice;
    }

    public Double getMealsPrice() {
        return mealsPrice;
    }

    public void calculatePrice(User user, Accommodation accommodation) {
        if (user.getType() == AccountType.STUDENT || user.getType() == AccountType.PUPIL || user.getType() == AccountType.TEACHING_STAFF) {
            this.mealsPrice = STUDENT_MEALS_PRICE;
            if (accommodation.getServiceType() == ServiceType.HOTEL) {

                switch (accommodation.getAccommodationType()) {
                    case SINGLE:
                        this.roomPrice = STUDENT_HOTEL_SINGLE_PRICE;
                        break;
                    case DOUBLE:
                        this.roomPrice = STUDENT_HOTEL_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = STUDENT_HOTEL_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = STUDENT_HOTEL_APARTMENT_PRICE;
                        break;
                }
            } else if (accommodation.getServiceType() == ServiceType.EXTENDED) {
                switch (accommodation.getAccommodationType()) {
                    case SINGLE:
                        this.roomPrice = STUDENT_EXTENDED_SINGLE_PRICE;
                        break;
                    case DOUBLE:
                        this.roomPrice = STUDENT_EXTENDED_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = STUDENT_EXTENDED_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = STUDENT_EXTENDED_APARTMENT_PRICE;
                        break;
                }
            }else{
                switch (accommodation.getAccommodationType()) {
                    case DOUBLE:
                        this.roomPrice = STUDENT_EXTENDED_BASIC_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = STUDENT_EXTENDED_BASIC_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = STUDENT_EXTENDED_BASIC_APARTMENT_PRICE;
                        break;
                }
            }
        } else {
            this.mealsPrice = OTHER_MEALS_PRICE;
            if (accommodation.getServiceType() == ServiceType.HOTEL) {

                switch (accommodation.getAccommodationType()) {
                    case SINGLE:
                        this.roomPrice = OTHER_HOTEL_SINGLE_PRICE;
                        break;
                    case DOUBLE:
                        this.roomPrice = OTHER_HOTEL_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = OTHER_HOTEL_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = OTHER_HOTEL_APARTMENT_PRICE;
                        break;
                }
            } else if (accommodation.getServiceType() == ServiceType.EXTENDED) {
                switch (accommodation.getAccommodationType()) {
                    case SINGLE:
                        this.roomPrice = OTHER_EXTENDED_SINGLE_PRICE;
                        break;
                    case DOUBLE:
                        this.roomPrice = OTHER_EXTENDED_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = OTHER_EXTENDED_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = OTHER_EXTENDED_APARTMENT_PRICE;
                        break;
                }
            }else{
                switch (accommodation.getAccommodationType()) {
                    case DOUBLE:
                        this.roomPrice = OTHER_EXTENDED_BASIC_DOUBLE_PRICE;
                        break;
                    case SUITE:
                        this.roomPrice = OTHER_EXTENDED_BASIC_SUITE_PRICE;
                        break;
                    case APARTMENT:
                        this.roomPrice = OTHER_EXTENDED_BASIC_APARTMENT_PRICE;
                        break;
                }
            }
        }
    }

}
