package com.dd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin extends AbstractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
}
