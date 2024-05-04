package com.example.securityDemoEx.repo;

import com.example.securityDemoEx.entities.Role;
import com.example.securityDemoEx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
