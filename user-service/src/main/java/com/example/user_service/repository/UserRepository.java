package com.example.user_service.repository;

import java.util.Optional;

import org.apache.kafka.common.quota.ClientQuotaAlteration.Op;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed
    Optional<User> findByEmail(String email);

}
