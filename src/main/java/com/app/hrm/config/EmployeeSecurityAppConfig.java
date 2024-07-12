/**
 * 
 */
package com.app.hrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import com.app.hrm.filters.AuthoritiesLoggingAfterFilter;
import com.app.hrm.filters.AuthoritiesLoggingAtFilter;
import com.app.hrm.filters.CsrfCookieFilter;
import com.app.hrm.filters.JWTTokenGeneratorFilter;
import com.app.hrm.filters.JWTTokenValidatorFilter;
import com.app.hrm.filters.RequestValidationBeforeFilter;

/**
 * skavali
 */
@Configuration
public class EmployeeSecurityAppConfig {
	@Bean
	SecurityFilterChain defauSecurityFilterChain(HttpSecurity http) throws Exception {
		CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
		requestHandler.setCsrfRequestAttributeName("_csrf");
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/signUp")
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
				.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
				.addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
				.addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
				.authorizeHttpRequests((requests) -> requests.requestMatchers("/employeeRecord").hasRole("HR")
						.requestMatchers("/allEmployeeRecords").hasAnyRole("HR","ADMIN")
						.requestMatchers("/user").authenticated()
						.requestMatchers("/updateRecord").hasRole("ADMIN")
						.requestMatchers("/message","/signUp").permitAll())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
		return encode;
	}
}
