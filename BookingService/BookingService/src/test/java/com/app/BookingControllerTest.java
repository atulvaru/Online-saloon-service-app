package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.app.controller.BookingController;
import com.app.dto.BookingDto;
import com.app.service.BookingService;

class BookingControllerTest {

	@Mock
	private BookingService bookingService;

	@InjectMocks
	private BookingController bookingController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllBookings() {
		// Arrange
		BookingDto booking1 = new BookingDto();
		booking1.setId(1L);
		booking1.setPrice(100.0);

		BookingDto booking2 = new BookingDto();
		booking2.setId(2L);
		booking2.setPrice(200.0);

		List<BookingDto> bookings = Arrays.asList(booking1, booking2);
		when(bookingService.getAllBookings()).thenReturn(bookings);

		// Act
		ResponseEntity<List<BookingDto>> response = bookingController.getAllBookings();

		// Assert
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(2, response.getBody().size());
		assertEquals(1L, response.getBody().get(0).getId());
		assertEquals(2L, response.getBody().get(1).getId());
	}
}
