package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.app.entity.Gender;

/**
 * StaffDto represents the data transfer object for a staff member. It includes
 * the details required to manage staff members in the system.
 */
@Data
@Schema(description = "StaffDto model information")
public class StaffDto {

	/**
	 * Unique identifier for the staff member. Example: 1
	 */
	@Schema(description = "Unique identifier for the staff member", example = "1")
	private Long id;

	/**
	 * Name of the staff member. Example: John Doe
	 */
	@Schema(description = "Name of the staff member", example = "John Doe")
	private String name;

	/**
	 * Detailed information about the staff member. Example: Senior stylist with 10
	 * years of experience
	 */
	@Schema(description = "Details about the staff member", example = "Senior stylist with 10 years of experience")
	private String details;

	/**
	 * Gender of the staff member. Example: MALE
	 */
	@Schema(description = "Gender of the staff member", example = "MALE")
	private Gender gender;

	/**
	 * ID of the service associated with the staff member.
	 */
	@Schema(description = "ID of the service associated with the staff member")
	private Long serviceId;
}
