package com.app.repository;

import com.app.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ServiceRepository is a Spring Data JPA repository for managing
 * {@link Service} entities. It provides CRUD operations and query methods for
 * the Service entity.
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

	// No additional methods are defined here; JpaRepository provides
	// basic CRUD operations and query methods by default.

}
