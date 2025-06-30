package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.user_service.component.JwtUtil;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.entity.User;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    public UserDTO register(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        userRepository.save(user);

        // Send user registration event to Kafka
        public String login(String email, String password) {
        User user = userRepo.findByEmail(email).orElseThrow();  // Fetch user by email
        if (user.getPassword().equals(password)) {
            kafkaTemplate.send("user-login", email);      // Send login event to Kafka 
            return new JwtUtil().generateToken(email);          // Generate JWT token
        }
        throw new RuntimeException("Invalid credentials");  // Throw exception if credentials are invalid
    
    }

}
