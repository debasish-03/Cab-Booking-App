package com.dd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dd.exception.DriverNotFoundException;
import com.dd.model.Driver;
import com.dd.repository.IDriverRepository;

@Service
public class IDriverServiceImplementation implements IDriverService {

	@Autowired
	private IDriverRepository iDriverRepository;
	
	@Override
	public Driver insertDriver(Driver driver) {
		return iDriverRepository.save(driver);
	}

	@Override
	public Driver updateDriver(Integer driverId, Driver driver) throws DriverNotFoundException {
		Driver existingDriver = iDriverRepository.findById(driverId).orElseThrow(
				() -> new DriverNotFoundException("Driver", "Id", driverId));
		
		existingDriver.setAddress(driver.getAddress());
		existingDriver.setCab(driver.getCab());
		existingDriver.setEmail(driver.getEmail());
		existingDriver.setFirstName(driver.getFirstName());
		existingDriver.setLastName(driver.getLastName());
		existingDriver.setLicenseNumber(driver.getLicenseNumber());
		existingDriver.setMobileNumber(driver.getMobileNumber());
		existingDriver.setPassword(driver.getPassword());
		existingDriver.setRating(driver.getRating());
		existingDriver.setUsername(driver.getUsername());
		
		return existingDriver;
	}

	@Override
	public Driver deleteDriver(Integer driverId) throws DriverNotFoundException {
		Driver existingDriver = iDriverRepository.findById(driverId).orElseThrow(
				() -> new DriverNotFoundException("Driver", "Id", driverId));
		iDriverRepository.deleteById(driverId);
		
		return existingDriver;
	}

	@Override
	public List<Driver> viewAllDrivers() {
		return iDriverRepository.findAll();
	}

	@Override
	public Driver viewDriverById(Integer driverId) throws DriverNotFoundException {
		Driver existingDriver = iDriverRepository.findById(driverId).orElseThrow(
				() -> new DriverNotFoundException("Driver", "Id", driverId));
		return existingDriver;
	}

}
