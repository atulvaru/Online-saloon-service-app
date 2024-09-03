package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entity.Staff;

/**
 * Repository interface for managing {@link Staff} entities.
 * Extends JpaRepository to provide CRUD operations and additional querying capabilities.
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // No additional methods are defined here, but JpaRepository provides
    // built-in methods such as save, findById, findAll, deleteById, etc.
}
