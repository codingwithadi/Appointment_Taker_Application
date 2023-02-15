package com.appointment.taker.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.taker.app.entities.Appointment;
import com.appointment.taker.app.entities.User;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer>{

	List<Appointment> findByUser(User user);
}
