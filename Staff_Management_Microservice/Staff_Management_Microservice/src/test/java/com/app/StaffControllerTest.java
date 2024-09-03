package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.controller.StaffController;
import com.app.dto.StaffDto;
import com.app.service.StaffService;

class StaffControllerTest {

    @Mock
    private StaffService staffService;

    @InjectMocks
    private StaffController staffController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetStaffById() {
        // Arrange
        Long staffId = 1L;
        StaffDto staffDto = new StaffDto();
        staffDto.setId(staffId);


        when(staffService.getStaffById(staffId)).thenReturn(staffDto);

        // Act
        ResponseEntity<StaffDto> response = staffController.getStaffById(staffId);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(staffId, response.getBody().getId());
    }
}
