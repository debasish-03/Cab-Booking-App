package com.dd.service;

import com.dd.exception.AdminNotFoundException;
import com.dd.model.Admin;

public interface IAdminService {
	public Admin insertAdmin(Admin admin);
	public Admin updateAdmin(Integer id, Admin admin) throws AdminNotFoundException;
	public Admin deleteAdmin(Integer adminId) throws AdminNotFoundException;
}
