package com.project.fitnessmonolith.controller;

import com.project.fitnessmonolith.dto.ActivityRequest;
import com.project.fitnessmonolith.dto.ActivityResponse;
import com.project.fitnessmonolith.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping()
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request){
        return ResponseEntity.ok(activityService.trackActivity(request));
    }

    @GetMapping()
    public ResponseEntity<List<ActivityResponse>> getActivity(@RequestHeader(value = "X-User-ID") String userId){
        return ResponseEntity.ok(activityService.getActivityForUser(userId));
    }
}
