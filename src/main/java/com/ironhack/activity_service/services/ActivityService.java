package com.ironhack.activity_service.services;

import com.ironhack.activity_service.exceptions.ActivityNotFoundException;
import com.ironhack.activity_service.models.Activity;
import com.ironhack.activity_service.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public Activity findActivityById(Long id) throws ActivityNotFoundException {
        Optional<Activity> foundActivity = activityRepository.findById(id);

        if (foundActivity.isPresent()) {
            return foundActivity.get();
        } else {
            throw new ActivityNotFoundException("Actividad no encontrada");
        }
    }

}
