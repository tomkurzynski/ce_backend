package com.createvent.createvent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthenticationProvider authProvider;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
 
    
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
			http.cors().and().csrf().
	        	disable()
	            .authorizeRequests()
	            .antMatchers(HttpMethod.OPTIONS, "/**")
	            .permitAll()
	            .antMatchers(HttpMethod.GET, "/**")
	            .permitAll()
	            .anyRequest()
	            .authenticated()
	            .and()
	            .httpBasic();
	    }
	 
	 
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
//	 @Bean
//		CorsConfigurationSource corsConfigurationSource() {
//			CorsConfiguration configuration = new CorsConfiguration();
//			configuration.setAllowedOrigins(Arrays.asList("*"));
//			configuration.setAllowedMethods(Arrays.asList("*"));
//			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//			source.registerCorsConfiguration("/**", configuration);
//			return source;
//		}
}
