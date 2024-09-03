package com.app.controller;

import com.app.dto.UserDto;
import com.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing user profiles and authentication. Provides
 * endpoints for creating, retrieving, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "APIs for managing user profiles and authentication")
public class UserController {

	@Autowired
	private UserService userService; // Service class for handling user-related business logic

	/**
	 * Endpoint to create a new user.
	 * 
	 * @param userDto Data transfer object containing user details
	 * @return ResponseEntity containing the created UserDto
	 */
	@Operation(summary = "Create a new user", description = "Create a new user with the provided details")
	@ApiResponse(responseCode = "200", description = "User created successfully")
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto createdUser = userService.createUser(userDto);
		return ResponseEntity.ok(createdUser); // Return the created user details
	}

	/**
	 * Endpoint to retrieve a user by their unique ID.
	 * 
	 * @param id Unique identifier of the user
	 * @return ResponseEntity containing the UserDto of the requested user
	 */
	@Operation(summary = "Get user by ID", description = "Retrieve a user by their unique ID")
	@ApiResponse(responseCode = "200", description = "User retrieved successfully")
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
		UserDto userDto = userService.getUserById(id);
		return ResponseEntity.ok(userDto); // Return the user details
	}

	/**
	 * Endpoint to update the details of an existing user.
	 * 
	 * @param id      Unique identifier of the user
	 * @param userDto Data transfer object containing updated user details
	 * @return ResponseEntity containing the updated UserDto
	 */
	@Operation(summary = "Update an existing user", description = "Update the details of an existing user")
	@ApiResponse(responseCode = "200", description = "User updated successfully")
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
		UserDto updatedUser = userService.updateUser(id, userDto);
		return ResponseEntity.ok(updatedUser); // Return the updated user details
	}

	/**
	 * Endpoint to delete a user by their unique ID.
	 * 
	 * @param id Unique identifier of the user to be deleted
	 * @return ResponseEntity with no content
	 */
	@Operation(summary = "Delete a user by ID", description = "Delete a user by their unique ID")
	@ApiResponse(responseCode = "204", description = "User deleted successfully")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build(); // Return no content status
	}

	/**
	 * Endpoint to retrieve a list of all users.
	 * 
	 * @return ResponseEntity containing a list of UserDto
	 */
	@Operation(summary = "Get all users", description = "Retrieve a list of all users")
	@ApiResponse(responseCode = "200", description = "List of users retrieved successfully")
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		return ResponseEntity.ok(users); // Return the list of all users
	}

}
