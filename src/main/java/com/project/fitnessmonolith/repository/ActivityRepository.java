package com.project.fitnessmonolith.repository;
import com.project.fitnessmonolith.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

}
