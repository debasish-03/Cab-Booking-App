package com.dd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.model.Driver;
import com.dd.service.IDriverService;

@Controller
@RequestMapping("api/vi/driver")
public class DriverController {
	
	@Autowired
	private IDriverService iDriverService;
	
	@PostMapping("save")
	public ResponseEntity<String> saveDriver(@RequestBody Driver driver) {
		Driver driverObj = iDriverService.insertDriver(driver);
		String response = "Driver created successfully\n"
				+ "Please note your username and password.\n"
				+ "username: " + driverObj.getUsername() + "\n"
				+ "password: " + driverObj.getPassword();
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("update/{driverId}")
	public ResponseEntity<String> updateDriver(@PathVariable("driverId") Integer driverId, @RequestBody Driver driver) {
		String response = "";
		HttpStatus httpStatus;
		try {
			iDriverService.updateDriver(driverId, driver);
			response = "Driver details updated successfully";
			httpStatus = HttpStatus.OK;
		} catch(Exception e) {
			response = "Error while updating the driver details";
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}
	
	@DeleteMapping("delete/{driverId}")
	public ResponseEntity<String> deleteDriver(@PathVariable("driverId") Integer driverId) {
		String response = "";
		HttpStatus httpStatus;
		try {
			Driver driverObj = iDriverService.deleteDriver(driverId);
			response = driverObj.getUsername() + " deleted successfully.";
			httpStatus = HttpStatus.OK;
		} catch(Exception e) {
			response = "Error while deleting the driver";
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<String>(response, httpStatus); 
	}
	
	@GetMapping("all")
	public List<Driver> getAllDriver() {
		return iDriverService.viewAllDrivers();
	}
	
	@GetMapping()
	public ResponseEntity<String> getDriverById(Integer driverId) {
		String response = "";
		HttpStatus httpStatus;
		try {
			Driver driver = iDriverService.viewDriverById(driverId);
			response = "Driver details: "
					+"\n"+driver.toString();
			httpStatus = HttpStatus.OK;
		}catch (Exception e) {
			response = "Driver details not found.";
			httpStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<String>(response, httpStatus);
	}
	
}
















