package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.models.Activity;
import server.models.User;
import server.repositories.ActivityRepository;
import server.repositories.UserRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityByID(UUID id) {
        return activityRepository.findById(id);
    }

    public List<Activity> search(LocalDate first, LocalDate second) {
        List<Activity> allActivities = activityRepository.findAll();
        List<Activity> filteredActivities = new ArrayList<>();
        for(Activity activity : allActivities){
            if((activity.getDate().isAfter(first) || activity.getDate().equals(first) && (activity.getDate().isBefore(second) || activity.getDate().equals(second)))){
                filteredActivities.add(activity);
            }
        }
        return filteredActivities;
    }
    public Activity participate(UUID activityID, UUID userID){
        Optional<Activity> activity = getActivityByID(activityID);
        Optional<User> user = userRepository.findById(userID);
        List<User> participants = activity.get().getParticipants();
        participants.add(user.get());
        activity.get().setParticipants(participants);
        return activityRepository.save(activity.get());
    }
// below are used to generate activities in DB
    public void create(Activity activity) {
        activity.setActivityID(UUID.randomUUID());
        activityRepository.save(activity);
    }
    public boolean addActivities(){
        List<Activity> activities = List.of(new Activity(LocalDate.now().plusDays(1),100,"Football day","What a great day to play sports!",20D),
                new Activity(LocalDate.now().plusDays(1),100,"Basketball day","What a great day to play sports!",20D),
                new Activity(LocalDate.now().plusDays(2),120,"Hiking day","We are planning a full day of adventures!",15D),
                new Activity(LocalDate.now().plusDays(3),150,"Books Club day","Don't forget to bring your favorite book",10D),
                new Activity(LocalDate.now().plusDays(4),60,"Robotics Club Day","The perfect opportunity for learning!",10D),
                new Activity(LocalDate.now().plusDays(5),70,"Ready for the party?","Get ready for a great party!",50D));
        for(Activity activity : activities)
            create(activity);
        return true;
    }
}
