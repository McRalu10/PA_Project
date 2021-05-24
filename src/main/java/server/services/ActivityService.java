package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.models.Activity;
import server.models.User;
import server.repositories.ActivityRepository;
import server.repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

}
