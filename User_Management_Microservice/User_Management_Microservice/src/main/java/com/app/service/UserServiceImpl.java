package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.Users;
import com.app.exception.UserException;
import com.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository; // Repository for accessing user data

	@Autowired
	private ModelMapper modelMapper; // ModelMapper for DTO to entity conversion

	/**
	 * Creates a new user based on the provided UserDto.
	 * 
	 * @param userDto Data transfer object containing user details
	 * @return The created UserDto with assigned ID
	 */
	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = modelMapper.map(userDto, Users.class); // Convert UserDto to Users entity
		// Ensure mobileNo is provided
		if (user.getMobileNo() == null) {
			throw new UserException("Mobile number must not be null");
		}
		Users savedUser = userRepository.save(user); // Save user to the repository
		return modelMapper.map(savedUser, UserDto.class); // Convert saved user to UserDto
	}

	/**
	 * Retrieves a user by their unique ID.
	 * 
	 * @param id Unique identifier of the user
	 * @return The UserDto corresponding to the provided ID
	 * @throws UserException if user is not found
	 */
	@Override
	public UserDto getUserById(Long id) {
		Optional<Users> user = userRepository.findById(id); // Find user by ID
		return user.map(u -> modelMapper.map(u, UserDto.class)) // Convert entity to DTO
				.orElseThrow(() -> new UserException("User not found with id " + id)); // Throw exception if not found
	}

	/**
	 * Retrieves a list of all users.
	 * 
	 * @return A list of UserDto objects representing all users
	 */
	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream() // Retrieve all users
				.map(user -> modelMapper.map(user, UserDto.class)) // Convert entities to DTOs
				.collect(Collectors.toList()); // Collect as a list
	}

	/**
	 * Updates the details of an existing user.
	 * 
	 * @param id      Unique identifier of the user to be updated
	 * @param userDto Data transfer object containing updated user details
	 * @return The updated UserDto
	 * @throws UserException if user is not found
	 */
	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
		Users existingUser = userRepository.findById(id)
				.orElseThrow(() -> new UserException("User not found with id " + id)); // Find existing user

		// Manually update fields
		existingUser.setName(userDto.getName());
		existingUser.setEmail(userDto.getEmail());
		existingUser.setMobileNo(userDto.getMobileNo());
		existingUser.setGender(userDto.getGender());
		// Update other fields as necessary

		Users updatedUser = userRepository.save(existingUser); // Save updated user
		return modelMapper.map(updatedUser, UserDto.class); // Convert updated user to UserDto
	}

	/**
	 * Deletes a user by their unique ID.
	 * 
	 * @param id Unique identifier of the user to be deleted
	 * @throws UserException if user is not found
	 */
	@Override
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserException("User not found with id " + id); // Throw exception if user does not exist
		}
		userRepository.deleteById(id); // Delete user by ID
	}
}
