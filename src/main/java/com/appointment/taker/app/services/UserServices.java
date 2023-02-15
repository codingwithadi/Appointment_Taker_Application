package com.appointment.taker.app.services;

import java.util.List;

import com.appointment.taker.app.payload.UserDTO;

public interface UserServices {
	
	//create
	UserDTO createUser(UserDTO userDto);
	
	//update
	UserDTO updateUser(UserDTO userDto, Integer userId);
	
	//getById
	UserDTO getUserById(Integer userId);
	
	//getAll
	List<UserDTO> getAllUser();
	
	//delete
	void deleteUser(Integer userId);

}
