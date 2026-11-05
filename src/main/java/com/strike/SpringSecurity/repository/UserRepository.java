package com.strike.SpringSecurity.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.strike.SpringSecurity.model.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByUsername(String username);
    
}
