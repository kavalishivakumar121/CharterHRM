/**
 * 
 */
package com.app.hrm.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.hrm.entity.Charter_EmployeeEntity;
import com.app.hrm.entity.EmployeRole;
import com.app.hrm.repo.Charter_EmployeeRepository;
/**
 * skavali
 */
@Configuration
public class EmpUserNamePwdAuthProvider implements AuthenticationProvider {
	@Autowired
	private Charter_EmployeeRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String employeeName = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<Charter_EmployeeEntity> employees = repository.findByEmail(employeeName);
		if (employees.size() > 0) {
			if (passwordEncoder.matches(password, employees.get(0).getPassword())) {
				return new UsernamePasswordAuthenticationToken(employeeName, password,
						getGrantedAuthorities(employees.get(0).getEmployeeRoles()));
			} else {
				throw new BadCredentialsException("Invalid password!");
			}
		} else {
			throw new BadCredentialsException("No user registered with this details!");
		}
	}
	private List<GrantedAuthority> getGrantedAuthorities(Set<EmployeRole> empRoles) {
		List<GrantedAuthority> grantedRoles = new ArrayList<>();
		for (EmployeRole role : empRoles) {
			grantedRoles.add(new SimpleGrantedAuthority(role.getName()));
		}
		return grantedRoles;
	}
	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
}