package com.example.LC_MVP.data;


import com.example.LC_MVP.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
	// Method to find a user by email
	Optional <User> findByEmail ( String email );
}

