package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.models.*;
import server.repositories.AccommodationRepository;
import server.repositories.UserRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getAccommodationByID(UUID id) {
        return accommodationRepository.findById(id);
    }

    public List<Accommodation> search(LocalDate first, LocalDate second, AccommodationType roomType) {
        List<Accommodation> allAccommodations = accommodationRepository.findAll();
        List<Accommodation> filteredAccommodations = new ArrayList<>();
        for (Accommodation accommodation : allAccommodations) {
            if (isAvailable(accommodation, first, second) && accommodation.getAccommodationType().equals(roomType)) {
                filteredAccommodations.add(accommodation);
            }
        }
        return filteredAccommodations;
    }

    public boolean isAvailable(Accommodation accommodation, LocalDate from, LocalDate to) {
        Map<LocalDate, LocalDate> booked = accommodation.getBookedDates();
        for (Map.Entry<LocalDate, LocalDate> entry : booked.entrySet()) {
            if ((entry.getKey().isAfter(from) && entry.getKey().isBefore(to)) || (entry.getValue().isAfter(from) && entry.getValue().isBefore(to)) || (entry.getKey().isAfter(from) && entry.getValue().isBefore(to))) {
                return false;
            }
        }
        return true;
    }

    public Accommodation book(Accommodation accommodation, UUID userID) {
        Optional<User> user = userRepository.findById(userID);
        if (accommodation.getServiceType().equals(ServiceType.EXTENDED_BASIC))
            accommodation.setCapacity(accommodation.getCapacity() - 1);

        user.get().setAccommodation(accommodation);
        userRepository.save(user.get());
        return accommodationRepository.save(accommodation);
    }

    // below are used to generate accommodations in DB

    public void create(Accommodation accommodation) {
        accommodation.setAccommodationID(UUID.randomUUID());
        accommodationRepository.save(accommodation);
    }
    public boolean addAccommodations(){
        List<Accommodation> accommodations = List.of(new Accommodation(AccommodationType.DOUBLE),
                new Accommodation(AccommodationType.SUITE),
                new Accommodation(AccommodationType.SINGLE),
                new Accommodation(AccommodationType.APARTMENT),
                new Accommodation(AccommodationType.DOUBLE),
                new Accommodation(AccommodationType.DOUBLE),
                new Accommodation(AccommodationType.SUITE),
                new Accommodation(AccommodationType.SINGLE),
                new Accommodation(AccommodationType.SINGLE),
                new Accommodation(AccommodationType.APARTMENT),
                new Accommodation(AccommodationType.SUITE)
        );
        for(Accommodation accommodation : accommodations )
            create(accommodation);
        return true;
    }
}
