package com.appointment.taker.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.taker.app.payload.AppointmentDTO;
import com.appointment.taker.app.response.ApiResponse;
import com.appointment.taker.app.service.implementation.AppointmentServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentServicesImpl appointmentServicesImpl;

	// Post method for save appointment
	@PostMapping("/user/{userId}/createAppointment")
	public ResponseEntity<AppointmentDTO> createAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO,
			@PathVariable("userId") Integer userId) {
		AppointmentDTO createdAppointment = this.appointmentServicesImpl.createAppointment(appointmentDTO, userId);
		return new ResponseEntity<AppointmentDTO>(createdAppointment, HttpStatus.CREATED);
	}

	// Get method by appointmentId
	@GetMapping("/getAppointment/{appointmentId}")
	public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable("appointmentId") Integer appointmentId) {
		AppointmentDTO getAppointment = this.appointmentServicesImpl.getAppointmentById(appointmentId);
		return new ResponseEntity<AppointmentDTO>(getAppointment, HttpStatus.OK);
	}

	// Get method for all Appointment By userId
	@GetMapping("/user/{userId}/getAllAppointments")
	public ResponseEntity<List<AppointmentDTO>> getAppointmentByUserId(@PathVariable("userId") Integer userId) {
		List<AppointmentDTO> getAllAppointments = this.appointmentServicesImpl.getByUserId(userId);
		return new ResponseEntity<List<AppointmentDTO>>(getAllAppointments, HttpStatus.OK);
	}

	// Get method for all Appointments only
	@GetMapping("/getAllAppointments")
	public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
		List<AppointmentDTO> getAllAppointment = this.appointmentServicesImpl.getAllAppointment();
		return new ResponseEntity<List<AppointmentDTO>>(getAllAppointment, HttpStatus.OK);
	}

	// Update / Put method for Appointment
	@PutMapping("/updateAppintment/{appointmentId}")
	public ResponseEntity<AppointmentDTO> updateAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO,
			@PathVariable("appointmentId") Integer appointmentId) {
		AppointmentDTO updatedAppointment = this.appointmentServicesImpl.updateAppointment(appointmentDTO,
				appointmentId);
		return new ResponseEntity<AppointmentDTO>(updatedAppointment, HttpStatus.OK);
	}

	// Delete method for delete appointment
	@DeleteMapping("/deleteAppointment/{appointmentId}")
	public ResponseEntity<ApiResponse> deleteAppointment(@PathVariable("appointmentId") Integer appointmentId) {
		this.appointmentServicesImpl.deleteAppointment(appointmentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Appointment Deleted Successfully!!", true),
				HttpStatus.OK);

	}

}
