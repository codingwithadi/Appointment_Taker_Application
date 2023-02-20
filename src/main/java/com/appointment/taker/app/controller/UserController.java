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

import com.appointment.taker.app.payload.UserDTO;
import com.appointment.taker.app.response.ApiResponse;
import com.appointment.taker.app.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	// User services
	@Autowired
	private UserServices userService;

	// Post Method for User Creation
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO createdUser = this.userService.createUser(userDto);
		return new ResponseEntity<UserDTO>(createdUser, HttpStatus.CREATED);
	}

	// Put method for User Updation
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto,
			@PathVariable("userId") Integer userId) {
		UserDTO updatedUser = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDTO>(updatedUser, HttpStatus.OK);
	}

	// Get method for Get User By Id
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Integer userId) {
		UserDTO gotUser = this.userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(gotUser, HttpStatus.OK);
	}

	// Get method for Get All User :: for Admin Access
	@GetMapping("/admin/getAllUser")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		List<UserDTO> allUsers = this.userService.getAllUser();
		return new ResponseEntity<List<UserDTO>>(allUsers, HttpStatus.OK);
	}

	// Delete method for Delete User
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully!!", true), HttpStatus.OK);
	}

}
