package com.dd.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractUser {
	private String username;
	private String password;
	private String address;
	private String mobileNumber;
	private String email;
}
