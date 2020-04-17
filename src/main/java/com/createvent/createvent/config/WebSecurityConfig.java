package com.createvent.createvent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	  @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//	        auth.inMemoryAuthentication()
//	                .withUser("user").password("{noop}password").roles("ADMIN");
//
//	    }
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http	
//			.authorizeRequests()
//				.antMatchers("/api/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/api").hasRole("ADMIN")
//			    .antMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
//			    .antMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN")
//			    .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/test")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//		}
//	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().
	        disable()
	            .authorizeRequests()
	            .antMatchers(HttpMethod.OPTIONS, "/**")
	            .permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .httpBasic();
	    }
}
