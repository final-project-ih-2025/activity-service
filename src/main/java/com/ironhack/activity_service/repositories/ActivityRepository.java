package com.ironhack.activity_service.repositories;

import com.ironhack.activity_service.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
