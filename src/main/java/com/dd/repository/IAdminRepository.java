package com.dd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dd.model.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
