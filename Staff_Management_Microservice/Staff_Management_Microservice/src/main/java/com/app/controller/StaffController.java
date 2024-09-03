package com.app.controller;

import com.app.dto.StaffDto;
import com.app.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * StaffController is a REST controller that handles CRUD operations for staff
 * members. It provides endpoints for creating, retrieving, updating, and
 * deleting staff members.
 */
@RestController
@RequestMapping("/api/staff")
@Tag(name = "Staff Management", description = "APIs for managing staff members")
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * Creates a new staff member.
     * 
     * @param staffDto The data transfer object containing the details of the staff member to be created.
     * @return A ResponseEntity containing the created StaffDto and HTTP status 201 (Created).
     */
    @Operation(summary = "Create a new staff member", description = "Create a new staff member in the system")
    @ApiResponse(responseCode = "201", description = "Staff created")
    @PostMapping
    public ResponseEntity<StaffDto> createStaff(@RequestBody StaffDto staffDto) {
        StaffDto createdStaff = staffService.createStaff(staffDto);
        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED);
    }

    /**
     * Retrieves a staff member by their ID.
     * 
     * @param id The ID of the staff member to be retrieved.
     * @return A ResponseEntity containing the StaffDto and HTTP status 200 (OK).
     */
    @Operation(summary = "Get a staff member by ID", description = "Retrieve details of a staff member by their ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved staff")
    @GetMapping("/{id}")
    public ResponseEntity<StaffDto> getStaffById(@PathVariable("id") Long id) {
        StaffDto staffDto = staffService.getStaffById(id);
        return new ResponseEntity<>(staffDto, HttpStatus.OK);
    }

    /**
     * Retrieves a list of all staff members.
     * 
     * @return A ResponseEntity containing the list of StaffDto and HTTP status 200 (OK).
     */
    @Operation(summary = "Get all staff members", description = "Retrieve a list of all staff members")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public ResponseEntity<List<StaffDto>> getAllStaff() {
        List<StaffDto> staffList = staffService.getAllStaff();
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }

    /**
     * Updates details of an existing staff member.
     * 
     * @param id         The ID of the staff member to be updated.
     * @param staffDto   The data transfer object containing the updated details of the staff member.
     * @return A ResponseEntity containing the updated StaffDto and HTTP status 200 (OK).
     */
    @Operation(summary = "Update a staff member", description = "Update details of an existing staff member")
    @ApiResponse(responseCode = "200", description = "Staff updated")
    @PutMapping("/{id}")
    public ResponseEntity<StaffDto> updateStaff(
            @PathVariable("id") Long id, 
            @RequestBody StaffDto staffDto) {
        StaffDto updatedStaff = staffService.updateStaff(id, staffDto);
        return new ResponseEntity<>(updatedStaff, HttpStatus.OK);
    }

    /**
     * Deletes a staff member by their ID.
     * 
     * @param id The ID of the staff member to be deleted.
     * @return A ResponseEntity with HTTP status 204 (No Content).
     */
    @Operation(summary = "Delete a staff member", description = "Remove a staff member from the system")
    @ApiResponse(responseCode = "204", description = "Staff deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable("id") Long id) {
        staffService.deleteStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
