package com.dd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dd.model.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Integer> {

}
