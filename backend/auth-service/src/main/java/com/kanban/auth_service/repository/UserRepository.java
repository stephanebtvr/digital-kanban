package com.kanban.auth_service.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.kanban.auth_service.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    // Utilisé pour l'authentification et la validation des tokens
    Optional<User> findByUsername(String username);
    
    // Utile pour vérifier les doublons lors de l'inscription
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
