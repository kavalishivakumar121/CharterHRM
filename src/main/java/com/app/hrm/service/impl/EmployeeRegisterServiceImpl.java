/**
 * 
 */
package com.app.hrm.service.impl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hrm.dto.Charter_EmployeeDto;
import com.app.hrm.entity.Charter_EmployeeEntity;
import com.app.hrm.entity.EmployeRole;
import com.app.hrm.repo.Charter_EmployeeRepository;
import com.app.hrm.repo.EmployeeRoleRepository;
import com.app.hrm.service.EmployeeRegisterService;

/**
 * skavali
 */

@Service
public class EmployeeRegisterServiceImpl implements EmployeeRegisterService{
	
	private Logger log=LoggerFactory.getLogger(EmployeeRegisterServiceImpl.class);
	@Autowired
	private Charter_EmployeeRepository repo;
	@Autowired
	private EmployeeRoleRepository roleRepo;
	private static final ModelMapper modelMapper = new ModelMapper();
	public Charter_EmployeeDto registerEmployee(Charter_EmployeeDto dto) {
		log.info("Employee Dto values are :"+dto);
		Charter_EmployeeEntity entity = modelMapper.map(dto, Charter_EmployeeEntity.class);
		log.info("Entity values are :"+entity);
		Set<EmployeRole> employeeRoles = entity.getEmployeeRoles();
		for (EmployeRole employeRole : employeeRoles) {
			roleRepo.save(employeRole);
		}
		Charter_EmployeeEntity save = repo.save(entity);
		log.info("Employee entity id :"+entity.getCgiId());
		dto.setCgiId(save.getCgiId());
		dto.setPassword(save.getPassword());
		return dto;
	}
}
