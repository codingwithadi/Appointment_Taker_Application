package com.appointment.taker.app.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.taker.app.entities.Appointment;
import com.appointment.taker.app.entities.User;
import com.appointment.taker.app.exception.ResourceNotFoundException;
import com.appointment.taker.app.payload.AppointmentDTO;
import com.appointment.taker.app.repo.AppointmentRepo;
import com.appointment.taker.app.repo.UserRepo;
import com.appointment.taker.app.services.AppointmentSevices;

@Service
public class AppointmentServicesImpl implements AppointmentSevices {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private AppointmentRepo appointmentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

		Appointment appointment = this.modelMapper.map(appointmentDTO, Appointment.class);

		appointment.setAppointmentSystemDate(new Date());
		appointment.setUser(user);

		Appointment savedAppointment = this.appointmentRepo.save(appointment);

		AppointmentDTO appointmentDto = this.modelMapper.map(savedAppointment, AppointmentDTO.class);

		return appointmentDto;
	}

	@Override
	public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO, Integer appointmentId) {
		Appointment appointment = this.appointmentRepo.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment", "ID", appointmentId));

		// update
		appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
		appointment.setAppointmentTime(appointmentDTO.getAppointmentTime());
		appointment.setAppointmentFor(appointmentDTO.getAppointmentFor());

		// save changes
		Appointment updatedAppointment = this.appointmentRepo.save(appointment);

		// mapping
		AppointmentDTO appointmentDto = this.modelMapper.map(updatedAppointment, AppointmentDTO.class);
		return appointmentDto;
	}

	@Override
	public AppointmentDTO getAppointmentById(Integer appointmentId) {
		Appointment appointment = this.appointmentRepo.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment", "ID", appointmentId));
		AppointmentDTO appointmentDto = this.modelMapper.map(appointment, AppointmentDTO.class);
		return appointmentDto;
	}

	@Override
	public List<AppointmentDTO> getByUserId(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

		List<Appointment> allAppointments = this.appointmentRepo.findByUser(user);
		List<AppointmentDTO> appointmentDtos = allAppointments.stream()
				.map((eAppointment) -> this.modelMapper.map(eAppointment, AppointmentDTO.class))
				.collect(Collectors.toList());

		return appointmentDtos;
	}

	@Override
	public List<AppointmentDTO> getAllAppointment() {
		List<Appointment> allAppointments = this.appointmentRepo.findAll();
		List<AppointmentDTO> appointmentDtos = allAppointments.stream()
				.map((eAppointment) -> this.modelMapper.map(eAppointment, AppointmentDTO.class))
				.collect(Collectors.toList());

		return appointmentDtos;
	}

	@Override
	public void deleteAppointment(Integer appointmentId) {
		Appointment appointment = this.appointmentRepo.findById(appointmentId).orElseThrow(()-> new ResourceNotFoundException("Appointment", "ID", appointmentId));
		this.appointmentRepo.delete(appointment);
	}

}
