package com.app.service;

import com.app.dto.StaffDto;
import java.util.List;

/**
 * staff interface for managing staff members. Provides methods for CRUD
 * operations and retrieving staff information.
 */
public interface StaffService {

	/**
	 * Creates a new staff member.
	 * 
	 * @param staffDto The staff member details to be created.
	 * @return The created staff member.
	 */
	StaffDto createStaff(StaffDto staffDto);

	/**
	 * Updates an existing staff member.
	 * 
	 * @param staffId  The ID of the staff member to be updated.
	 * @param staffDto The new details for the staff member.
	 * @return The updated staff member.
	 */
	StaffDto updateStaff(Long staffId, StaffDto staffDto);

	/**
	 * Deletes a staff member by their ID.
	 * 
	 * @param staffId The ID of the staff member to be deleted.
	 */
	void deleteStaff(Long staffId);

	/**
	 * Retrieves a staff member by their ID.
	 * 
	 * @param staffId The ID of the staff member to retrieve.
	 * @return The staff member with the specified ID.
	 */
	StaffDto getStaffById(Long staffId);

	/**
	 * Retrieves a list of all staff members.
	 * 
	 * @return A list of all staff members.
	 */
	List<StaffDto> getAllStaff();
}
