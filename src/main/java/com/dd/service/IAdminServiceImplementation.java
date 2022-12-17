package com.dd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.exception.AdminNotFoundException;
import com.dd.model.Admin;
import com.dd.repository.IAdminRepository;

@Service
public class IAdminServiceImplementation implements IAdminService {
	
	@Autowired
	private IAdminRepository iAdminRepository;
	
	@Override
	public Admin insertAdmin(Admin admin) {
		return iAdminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Integer id, Admin admin) throws AdminNotFoundException {
		Admin existingAdmin = iAdminRepository.findById(id).orElseThrow(
				() -> new AdminNotFoundException("Admin", "Id", id));
		
		existingAdmin.setAddress(admin.getAddress());
		existingAdmin.setEmail(admin.getEmail());
		existingAdmin.setMobileNumber(admin.getMobileNumber());
		existingAdmin.setUsername(admin.getUsername());
		existingAdmin.setPassword(admin.getPassword());
		existingAdmin.setFirstName(admin.getFirstName());
		existingAdmin.setLastName(admin.getFirstName());
		
		iAdminRepository.save(existingAdmin);
		return existingAdmin;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminNotFoundException {
		Admin admin = iAdminRepository.findById(adminId).orElseThrow(
				() -> new AdminNotFoundException("Admin", "Id", adminId));
		iAdminRepository.deleteById(adminId);
		return admin;
	}


}
