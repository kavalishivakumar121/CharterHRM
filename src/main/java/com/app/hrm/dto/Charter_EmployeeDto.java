/**
 * 
 */
package com.app.hrm.dto;

import java.io.Serializable;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.app.hrm.entity.EmployeRole;

import jakarta.persistence.Column;

/**
 * skavali
 */
public class Charter_EmployeeDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cgiId;
	private String fName;
	private String lName;
	private String fullName;
	private String email;
	private String password;
	private long mobileNumber;
	private Set<EmployeRole> employeeRoles;
	
	


	
	/**
	 * @param cgiId
	 * @param fName
	 * @param lName
	 * @param fullName
	 * @param email
	 * @param password
	 * @param mobileNumber
	 * @param employeeRoles
	 */
	public Charter_EmployeeDto(Integer cgiId, String fName, String lName, String fullName, String email,
			String password, long mobileNumber, Set<EmployeRole> employeeRoles) {
		super();
		this.cgiId = cgiId;
		this.fName = fName;
		this.lName = lName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.employeeRoles = employeeRoles;
	}
	/**
	 * @return the cgiId
	 */
	public Integer getCgiId() {
		return cgiId;
	}
	/**
	 * @param cgiId the cgiId to set
	 */
	public void setCgiId(Integer cgiId) {
		this.cgiId = cgiId;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mobileNumber
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the employeeRoles
	 */
	public Set<EmployeRole> getEmployeeRoles() {
		return employeeRoles;
	}
	/**
	 * @param employeeRoles the employeeRoles to set
	 */
	public void setEmployeeRoles(Set<EmployeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}
	/**
	 * 
	 */
	public Charter_EmployeeDto() {
		super();
	}
	@Override
	public String toString() {
		return "Charter_EmployeeDto [cgiId=" + cgiId + ", fName=" + fName + ", lName=" + lName + ", fullName="
				+ fullName + ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", employeeRoles=" + employeeRoles + "]";
	}
	
}
