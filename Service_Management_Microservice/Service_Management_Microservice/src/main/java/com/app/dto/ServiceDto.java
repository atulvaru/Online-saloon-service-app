package com.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ServiceDto is a data transfer object used to transfer service data between
 * layers of the application. It includes fields for the service ID, name,
 * detail, and price.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "ServiceDto model information")
public class ServiceDto {

	/**
	 * The unique identifier of the service. This is an auto-generated value.
	 */
	@Schema(description = "Unique identifier of the service", example = "1")
	private Long id;

	/**
	 * The name of the service. Example: "Haircut"
	 */
	@Schema(description = "Name of the service", example = "Haircut")
	private String name;

	/**
	 * A detailed description of the service. Example: "A professional haircut
	 * service"
	 */
	@Schema(description = "Detailed description of the service", example = "A professional haircut service")
	private String detail;

	/**
	 * The price of the service. Example: 25.50
	 */
	@Schema(description = "Price of the service", example = "25.50")
	private Double price;

}
