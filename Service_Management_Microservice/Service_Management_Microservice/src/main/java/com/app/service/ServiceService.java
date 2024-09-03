package com.app.service;

import java.util.List;

import com.app.dto.ServiceDto;

/**
 * ServiceService is an interface that defines the contract for service-related
 * operations, including creation, update, deletion, and retrieval of services.
 */
public interface ServiceService {

	/**
	 * Creates a new service.
	 *
	 * @param serviceDto The data transfer object representing the service to be
	 *                   created.
	 * @return The created ServiceDto.
	 */
	ServiceDto createService(ServiceDto serviceDto);

	/**
	 * Updates an existing service.
	 *
	 * @param serviceId  The ID of the service to be updated.
	 * @param serviceDto The data transfer object containing updated service
	 *                   details.
	 * @return The updated ServiceDto.
	 */
	ServiceDto updateService(Long serviceId, ServiceDto serviceDto);

	/**
	 * Deletes a service by its ID.
	 *
	 * @param serviceId The ID of the service to be deleted.
	 */
	String deleteService(Long serviceId);

	/**
	 * Retrieves a service by its ID.
	 *
	 * @param serviceId The ID of the service to be retrieved.
	 * @return The ServiceDto of the retrieved service.
	 */
	ServiceDto getServiceById(Long serviceId);

	/**
	 * Retrieves a list of all services.
	 *
	 * @return A list of ServiceDto representing all services.
	 */
	List<ServiceDto> getAllServices();
}
