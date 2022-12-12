package com.dd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "driver")
public class Driver extends AbstractUser {

}
