package com.dd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "driver")
public class Driver extends AbstractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	private String licenseNumber;
	@OneToOne
	private Cab cab;
	private float rating;
}
