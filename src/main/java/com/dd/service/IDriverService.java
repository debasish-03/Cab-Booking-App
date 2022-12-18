package com.dd.service;

import java.util.List;

import com.dd.exception.DriverNotFoundException;
import com.dd.model.Driver;

public interface IDriverService {
	public Driver insertDriver(Driver driver);
	public Driver updateDriver(Integer driverId, Driver driver) throws DriverNotFoundException;
	public Driver deleteDriver(Integer driverId) throws DriverNotFoundException;
	public List<Driver> viewAllDrivers();
	public Driver viewDriverById(Integer driverId) throws DriverNotFoundException;
}
