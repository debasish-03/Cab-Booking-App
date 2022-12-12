package com.dd.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trip_booking")
public class TripBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tripBookingId;
	private int customerId;
	@ManyToOne
	private Driver driver;
	private String fromLocation;
	private String toLocation;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime fromDateTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime toDateTime;
	private boolean status;
	private float distanceInKm;
	private float bill;
}
