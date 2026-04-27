package com.project.fitnessmonolith.service;

import com.project.fitnessmonolith.dto.ActivityRequest;
import com.project.fitnessmonolith.dto.ActivityResponse;
import com.project.fitnessmonolith.model.Activity;
import com.project.fitnessmonolith.model.User;
import com.project.fitnessmonolith.repository.ActivityRepository;
import com.project.fitnessmonolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final UserRepository userRepository;
    public ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));
        Activity activity = Activity.builder()
                .type(request.getType())
                .user(user)
                .additionalMetrics(request.getAdditionalMetrics())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity savedActivity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(savedActivity.getId());
        response.setUserId(savedActivity.getUser().getId());
        response.setType(savedActivity.getType());
        response.setAdditionalMetrics(savedActivity.getAdditionalMetrics());
        response.setDuration(savedActivity.getDuration());
        response.setCaloriesBurned(savedActivity.getCaloriesBurned());
        response.setStartTime(savedActivity.getStartTime());
        response.setCreatedAt(savedActivity.getCreatedAt());
        response.setUpdatedAt(savedActivity.getUpdatedAt());
        return response;
    }
}
