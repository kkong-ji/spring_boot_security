package com.example.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security1.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}