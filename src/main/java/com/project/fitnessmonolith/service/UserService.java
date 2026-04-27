package com.project.fitnessmonolith.service;

import com.project.fitnessmonolith.dto.RegisterRequest;
import com.project.fitnessmonolith.dto.UserResponse;
import com.project.fitnessmonolith.model.User;
import com.project.fitnessmonolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {
        User user = new User(
                null,
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName(),
                Instant.parse("2024-01-01T00:00:00Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
                Instant.parse("2024-01-01T00:00:00Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
                List.of(),
                List.of()
        );

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
