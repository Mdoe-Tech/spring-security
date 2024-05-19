package com.mdoe.demo_security.repository;

import com.mdoe.demo_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByFirstName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
