/**
 * 
 */
package com.app.hrm.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * skavali
 */
@Entity
@Table(name="Charter_EmployeeEntity")
public class Charter_EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cgi_Id")
	private Integer cgiId;
	@Column(name = "first_Name")
	private String fName;
	@Column(name = "last_Name")
	private String lName;
	@Column(name = "full_Name")
	private String fullName;
	@Column(name = "email")
	private String email;
	@Column(name = "pwd")
	private String password;
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
	@Column(name = "mobile_Number")
	private long mobileNumber;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_role",
            joinColumns = @JoinColumn(name = "cgi_Id"),
            inverseJoinColumns = @JoinColumn(name = "role_Id")
    )
	private Set<EmployeRole> employeeRoles =new HashSet<>();
    
    
    
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
	public Charter_EmployeeEntity(Integer cgiId, String fName, String lName, String fullName, String email,
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
	public Charter_EmployeeEntity() {
		super();
	}
	@Override
	public String toString() {
		return "Charter_EmployeeEntity [cgiId=" + cgiId + ", fName=" + fName + ", lName=" + lName + ", fullName="
				+ fullName + ", email=" + email + ", password=" + password + ", mobileNumber=" + mobileNumber
				+ ", employeeRoles=" + employeeRoles + "]";
	}
		
}
