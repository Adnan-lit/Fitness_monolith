package com.project.fitnessmonolith.service;

import com.project.fitnessmonolith.model.User;
import com.project.fitnessmonolith.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }
}
