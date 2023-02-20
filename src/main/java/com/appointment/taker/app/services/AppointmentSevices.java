package com.appointment.taker.app.services;

import java.util.List;

import com.appointment.taker.app.payload.AppointmentDTO;

public interface AppointmentSevices {

	// create
	AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, Integer userId);

	// update
	AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO, Integer appointmentId);

	// get by Id
	AppointmentDTO getAppointmentById(Integer appointmentId);

	// get by userId
	List<AppointmentDTO> getByUserId(Integer userId);

	// get all for admin
	List<AppointmentDTO> getAllAppointment();

	// delete
	void deleteAppointment(Integer appointmentId);

}
