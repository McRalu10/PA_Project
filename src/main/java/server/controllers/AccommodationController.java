package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.models.Accommodation;
import server.models.AccommodationType;
import server.services.AccommodationService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/accommodation")
public class AccommodationController {
    @Autowired
    private AccommodationService service;

    @GetMapping("/all")
    public ResponseEntity<List<Accommodation>> getAccommodations() {
        List<Accommodation> accommodations = service.getAllAccommodations();
        return new ResponseEntity<>(accommodations, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccommodationByID(@PathVariable UUID id) {
        Optional<Accommodation> existingAccommodation = service.getAccommodationByID(id);
        if (existingAccommodation.isEmpty()) {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(existingAccommodation, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String first, @RequestParam String second, @RequestParam AccommodationType roomType){
        List<Accommodation> result = service.search(LocalDate.parse(first),LocalDate.parse(second),roomType);
        if(result.equals(new ArrayList<>())){
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/book/{userID}")
    public ResponseEntity<?> participate(@RequestBody Accommodation accommodation, @PathVariable UUID userID){
        return new ResponseEntity<>(service.book(accommodation,userID),new HttpHeaders(),HttpStatus.OK);
    }

    //do not use
    @PostMapping("/add/accommodations")
    public ResponseEntity<?> addAccommodations(){
        return new ResponseEntity<>(service.addAccommodations(),new HttpHeaders(),HttpStatus.OK);
    }
}
