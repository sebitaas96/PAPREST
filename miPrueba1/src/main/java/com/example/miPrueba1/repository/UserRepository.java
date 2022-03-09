package com.example.miPrueba1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.miPrueba1.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{}