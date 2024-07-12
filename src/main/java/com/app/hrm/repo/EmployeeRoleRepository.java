/**
 * 
 */
package com.app.hrm.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.hrm.entity.EmployeRole;

/**
 * skavali
 */
@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeRole, Integer> {
	public List<EmployeRole> findByName(String name);
}
