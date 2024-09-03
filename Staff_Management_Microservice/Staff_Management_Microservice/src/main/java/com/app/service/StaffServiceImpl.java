package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.StaffDto;
import com.app.entity.Staff;
import com.app.exception.StaffException;
import com.app.repository.StaffRepository;

/**
 * Implementation of the {@link StaffService} interface. Provides methods for
 * managing staff members, including CRUD operations.
 */
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Creates a new staff member.
	 * 
	 * @param staffDto The staff member details to be created.
	 * @return The created staff member.
	 */
	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		// Convert DTO to Entity
		Staff staff = modelMapper.map(staffDto, Staff.class);
		// Save the entity
		Staff savedStaff = staffRepository.save(staff);
		// Convert back to DTO
		return modelMapper.map(savedStaff, StaffDto.class);
	}

	/**
	 * Updates an existing staff member.
	 * 
	 * @param staffId  The ID of the staff member to be updated.
	 * @param staffDto The new details for the staff member.
	 * @return The updated staff member.
	 */
	@Override
	public StaffDto updateStaff(Long staffId, StaffDto staffDto) {
		// Find existing staff member
		Staff existingStaff = staffRepository.findById(staffId)
				.orElseThrow(() -> new StaffException("Staff member not found"));
		// Update entity fields
		modelMapper.map(staffDto, existingStaff);
		// Save updated entity
		Staff updatedStaff = staffRepository.save(existingStaff);
		// Convert back to DTO
		return modelMapper.map(updatedStaff, StaffDto.class);
	}

	/**
	 * Deletes a staff member by their ID.
	 * 
	 * @param staffId The ID of the staff member to be deleted.
	 */
	@Override
	public void deleteStaff(Long staffId) {
		staffRepository.deleteById(staffId);
	}

	/**
	 * Retrieves a staff member by their ID.
	 * 
	 * @param staffId The ID of the staff member to retrieve.
	 * @return The staff member with the specified ID.
	 */
	@Override
	public StaffDto getStaffById(Long staffId) {
		// Find staff member by ID
		Staff staff = staffRepository.findById(staffId)
				.orElseThrow(() -> new StaffException("Staff member not found"));
		// Convert to DTO
		return modelMapper.map(staff, StaffDto.class);
	}

	/**
	 * Retrieves a list of all staff members.
	 * 
	 * @return A list of all staff members.
	 */
	@Override
	public List<StaffDto> getAllStaff() {
		// Find all staff members
		List<Staff> staffList = staffRepository.findAll();
		// Convert to DTO list
		return staffList.stream().map(staff -> modelMapper.map(staff, StaffDto.class)).collect(Collectors.toList());
	}
}
