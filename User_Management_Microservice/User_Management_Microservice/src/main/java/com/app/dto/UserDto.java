package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user information.
 * Used to transfer user data between layers or services.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "UserDto model information")
public class UserDto {

	/**
	 * Unique identifier of the user.
	 * 
	 * @example 1
	 */
	@Schema(description = "Unique identifier of the user", example = "1")
	private Long id;

	/**
	 * Name of the user.
	 * 
	 * @example John Doe
	 */
	@Schema(description = "Name of the user", example = "John Doe")
	private String name;

	/**
	 * Email address of the user.
	 * 
	 * @example john.doe@example.com
	 */
	@Schema(description = "Email address of the user", example = "john.doe@example.com")
	private String email;

	/**
	 * Mobile number of the user.
	 * 
	 * @example +1234567890
	 */
	@Schema(description = "Mobile number of the user", example = "+1234567890")
	private String mobileNo;
	
	/**
	 * Password of the user.
	 * 
	 * @example 123456789
	 */
	@Schema(description = "Password of the user", example = "123456789")
	private String password;

	/**
	 * Gender of the user.
	 * 
	 * @example Male
	 */
	@Schema(description = "Gender of the user", example = "Male")
	private String gender;
}
