package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Service entity represents a service in the system. It includes attributes
 * like ID, name, detail, and price, which describe a particular service
 * offered.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Service {

	/**
	 * The unique identifier for the service.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * The name of the service. This field is required.
	 */
	@Column(nullable = false)
	private String name;

	/**
	 * Detailed description of the service. This field is required.
	 */
	@Column(nullable = false)
	private String detail;

	/**
	 * The price of the service. This field is required.
	 */
	@Column(nullable = false)
	private Double price;

}
