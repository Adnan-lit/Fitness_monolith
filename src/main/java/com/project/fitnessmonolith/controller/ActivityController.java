package com.project.fitnessmonolith.controller;

import com.project.fitnessmonolith.dto.ActivityRequest;
import com.project.fitnessmonolith.dto.ActivityResponse;
import com.project.fitnessmonolith.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ActivityResponse> getActivity(){
        return ResponseEntity.ok(new ActivityResponse());
    }
}
