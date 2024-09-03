package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ServiceDto;
import com.app.exception.ServiceException;
import com.app.repository.ServiceRepository;

/**
 * ServiceServiceImpl is the implementation class of the ServiceService
 * interface. It handles the business logic related to services, including
 * creation, update, deletion, and retrieval operations.
 */
@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Creates a new service by converting the provided DTO to an entity, saving it,
	 * and then converting the saved entity back to a DTO.
	 *
	 * @param serviceDto The data transfer object representing the service to be
	 *                   created.
	 * @return The created ServiceDto.
	 */
	@Override
	public ServiceDto createService(ServiceDto serviceDto) {
		// Convert DTO to Entity
		com.app.entity.Service serviceEntity = modelMapper.map(serviceDto, com.app.entity.Service.class);
		// Save the entity
		com.app.entity.Service savedService = serviceRepository.save(serviceEntity);
		// Convert back to DTO
		return modelMapper.map(savedService, ServiceDto.class);
	}

	/**
	 * Updates an existing service by finding it by ID, updating its fields with
	 * values from the provided DTO, saving the updated entity, and converting it
	 * back to a DTO.
	 *
	 * @param serviceId  The ID of the service to be updated.
	 * @param serviceDto The data transfer object containing updated service
	 *                   details.
	 * @return The updated ServiceDto.
	 */
	@Override
	public ServiceDto updateService(Long serviceId, ServiceDto serviceDto) {
		// Find existing entity
		com.app.entity.Service existingService = serviceRepository.findById(serviceId)
				.orElseThrow(() -> new ServiceException("Service not found"));

		// Update entity fields
		existingService.setName(serviceDto.getName());
		existingService.setDetail(serviceDto.getDetail());
		existingService.setPrice(serviceDto.getPrice());

		// Save updated entity
		com.app.entity.Service updatedService = serviceRepository.save(existingService);

		// Convert back to DTO
		return modelMapper.map(updatedService, ServiceDto.class);
	}

	/**
	 * Deletes an existing service by finding it by ID and then deleting it.
	 *
	 * @param serviceId The ID of the service to be deleted.
	 */
	@Override
	public String deleteService(Long serviceId) {
		// Find existing entity
		com.app.entity.Service existingService = serviceRepository.findById(serviceId)
				.orElseThrow(() -> new ServiceException("Service not found" + serviceId));

		// Delete entity
		serviceRepository.delete(existingService);
		return "Deleted Successfully";
	}

	/**
	 * Retrieves a service by its ID and converts it to a DTO.
	 *
	 * @param serviceId The ID of the service to be retrieved.
	 * @return The ServiceDto of the retrieved service.
	 */
	@Override
	public ServiceDto getServiceById(Long serviceId) {
		// Find entity by ID
		com.app.entity.Service service = serviceRepository.findById(serviceId)
				.orElseThrow(() -> new ServiceException("Service not found" + serviceId));

		// Convert to DTO
		return modelMapper.map(service, ServiceDto.class);
	}

	/**
	 * Retrieves all services, converts them to DTOs, and returns the list of DTOs.
	 *
	 * @return A list of ServiceDto representing all services.
	 */
	@Override
	public List<ServiceDto> getAllServices() {
		// Find all services
		List<com.app.entity.Service> services = serviceRepository.findAll();

		// Convert to DTO list
		return services.stream().map(service -> modelMapper.map(service, ServiceDto.class))
				.collect(Collectors.toList());
	}
}
