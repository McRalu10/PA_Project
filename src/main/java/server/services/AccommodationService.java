package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.models.Accommodation;
import server.models.AccountType;
import server.repositories.AccommodationRepository;

import java.util.Date;
import java.util.List;

@Service
public class AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.findAll();
    }
//    public List<Accommodation> search(Date arrival, Date departure){
//
//    }


}
