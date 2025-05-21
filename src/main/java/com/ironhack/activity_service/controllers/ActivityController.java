package com.ironhack.activity_service.controllers;

import com.ironhack.activity_service.exceptions.ActivityNotFoundException;
import com.ironhack.activity_service.models.Activity;
import com.ironhack.activity_service.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable Long id) {

        try {
            Activity foundActivity = activityService.findActivityById(id);
            return new ResponseEntity<>(foundActivity, HttpStatus.OK);
        } catch (ActivityNotFoundException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

}
