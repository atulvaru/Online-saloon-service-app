package com.app;

import com.app.controller.ServiceController;
import com.app.dto.ServiceDto;
import com.app.service.ServiceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ServiceController.class)
class ServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceService serviceService;

	@Test
	void testCreateService() throws Exception {
		// Arrange
		ServiceDto serviceDto = new ServiceDto();
		serviceDto.setId(1L);
		serviceDto.setName("Haircut");
		serviceDto.setDetail("A basic haircut");
		serviceDto.setPrice(100.0);

		Mockito.when(serviceService.createService(any(ServiceDto.class))).thenReturn(serviceDto);

		// Act & Assert
		mockMvc.perform(post("/api/services").contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"Haircut\",\"detail\":\"A basic haircut\",\"price\":100.0}"))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id").value(1L))
				.andExpect(jsonPath("$.name").value("Haircut")).andExpect(jsonPath("$.price").value(100.0));
	}
}
