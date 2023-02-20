package com.appointment.taker.app.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.taker.app.entities.User;
import com.appointment.taker.app.exception.ResourceNotFoundException;
import com.appointment.taker.app.payload.UserDTO;
import com.appointment.taker.app.repo.UserRepo;
import com.appointment.taker.app.services.UserServices;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// save user
		User savedUser = this.userRepo.save(user);

		// Mapping User
		UserDTO userDTO = this.modelMapper.map(savedUser, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

		// updating user details
		user.setUserName(userDto.getUserName());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserMobileNumber(userDto.getUserMobileNumber());
		user.setUserWhatsAppNumber(userDto.getUserWhatsAppNumber());
		user.setUserPassword(userDto.getUserPassword());

		// update user
		User updateUser = this.userRepo.save(user);

		// Mapping User
		UserDTO userDTO = this.modelMapper.map(updateUser, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDTOs = users.stream().map((euser) -> this.modelMapper.map(euser, UserDTO.class))
				.collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		this.userRepo.delete(user);

	}

}
