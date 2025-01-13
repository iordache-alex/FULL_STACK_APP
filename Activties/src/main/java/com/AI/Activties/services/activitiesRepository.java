package com.AI.Activties.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AI.Activties.models.Activity;

public interface activitiesRepository extends JpaRepository<Activity, Integer> {

}
