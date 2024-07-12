/**
 * 
 */
package com.app.hrm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.hrm.entity.Charter_EmployeeEntity;

/**
 * skavali
 */
public interface Charter_EmployeeRepository extends JpaRepository<Charter_EmployeeEntity, Integer>{
	
	public List<Charter_EmployeeEntity> findByEmail(String email);
	

}
