package com.appointment.taker.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.taker.app.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
