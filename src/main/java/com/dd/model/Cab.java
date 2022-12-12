package com.dd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cab")
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cabId;
	private String carType;
	private float perKmRate;
}
