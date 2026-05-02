package com.project.fitnessmonolith.controller;

import com.project.fitnessmonolith.dto.RecommendationRequest;
import com.project.fitnessmonolith.model.Activity;
import com.project.fitnessmonolith.model.Recommendation;
import com.project.fitnessmonolith.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request) {
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendationByUserId(@PathVariable String userId) {
        List<Recommendation> recommendationList = recommendationService.getUserRecommendation(userId);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityByUserId(@PathVariable String activityId) {
        List<Recommendation> activityList = recommendationService.getActivityRecommendation(activityId);
        return ResponseEntity.ok(activityList);
    }
}