package com.dd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dd.model.Admin;
import com.dd.service.IAdminService;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
	
	@Autowired
	private IAdminService iAdminService;
	
	@PostMapping("save")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) {	
		return new ResponseEntity<Admin>(iAdminService.insertAdmin(admin), HttpStatus.CREATED);	
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updateAdmin(@PathVariable("id") Integer id, Admin admin) {
		try {
			iAdminService.updateAdmin(id, admin);
			return new ResponseEntity<String>("Admin updated successfully", HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<String>("Error while updating the data", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete/{adminId}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("adminId") Integer adminId) {
		try {
			iAdminService.deleteAdmin(adminId);
			return new ResponseEntity<String>("Sucessfully deleted.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error while deleting.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}





























