/**
 * 
 */
package com.app.hrm.entity;
import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * skavali
 */
@Entity
@Table(name="employeRole")
public class EmployeRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_Id")
	private Integer id;
	@Column(name = "role_Name")
	private String name;
    @ManyToMany(mappedBy = "employeeRoles")
    private Set<Charter_EmployeeEntity> employees;
	/**
	 * @return the id
	 */
    
	public Integer getId() {
		return id;
	}
	/**
	 * @param id
	 * @param name
	 * @param employees
	 */
	public EmployeRole(Integer id, String name, Set<Charter_EmployeeEntity> employees) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
	}
	/**
	 * @return the employees
	 */
	public Set<Charter_EmployeeEntity> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(Set<Charter_EmployeeEntity> employees) {
		this.employees = employees;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	public EmployeRole() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeRole [id=" + id + ", name=" + name + "]";
	}

}
