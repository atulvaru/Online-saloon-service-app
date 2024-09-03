package com.app.service;

import java.util.List;
import com.app.dto.UserDto;

/**
 * User interface for managing user-related operations.
 * Provides methods for creating, retrieving, updating, and deleting users.
 */
public interface UserService {

    /**
     * Creates a new user with the provided details.
     * 
     * @param userDto Data transfer object containing user details
     * @return The created UserDto with assigned ID
     */
    UserDto createUser(UserDto userDto);

    /**
     * Retrieves a user by their unique ID.
     * 
     * @param id Unique identifier of the user
     * @return The UserDto corresponding to the provided ID
     */
    UserDto getUserById(Long id);

    /**
     * Retrieves a list of all users.
     * 
     * @return A list of UserDto objects representing all users
     */
    List<UserDto> getAllUsers();

    /**
     * Updates the details of an existing user.
     * 
     * @param id Unique identifier of the user to be updated
     * @param userDto Data transfer object containing updated user details
     * @return The updated UserDto
     */
    UserDto updateUser(Long id, UserDto userDto);

    /**
     * Deletes a user by their unique ID.
     * 
     * @param id Unique identifier of the user to be deleted
     */
    void deleteUser(Long id);
}
