package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.models.Activity;
import server.services.ActivityService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/activities")
public class ActivityController {
    @Autowired
    private ActivityService service;

    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getActivities() {
        List<Activity> activities = service.getAllActivities();
        return new ResponseEntity<>(activities, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivityByID(@PathVariable UUID id) {
        Optional<Activity> existingActivity = service.getActivityByID(id);
        if (existingActivity.isEmpty()) {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(existingActivity, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam LocalDate first, @RequestParam LocalDate second){
        List<Activity> result = service.search(first,second);
        if(result.equals(new ArrayList<>())){
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping("/participate/{activityID}/{userID}")
    public ResponseEntity<?> participate(@PathVariable UUID activityID, @PathVariable UUID userID){
        return new ResponseEntity<>(service.participate(activityID,userID),new HttpHeaders(),HttpStatus.OK);
    }
}
