package com.createvent.createvent.config;

import java.util.ArrayList;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.createvent.createvent.service.UserService;

@Component
@CrossOrigin(origins = "*")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		try {
			String userEmail = userService.getByEmail(name).getEmail();
//			String pass = userService.getByEmail(name).getPassword();
			String pass = new String(Base64.getDecoder().decode(userService.getByEmail(name).getPassword()));

			if (userEmail.equalsIgnoreCase(name) && pass.equals(password)) {

				return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
			} else {
				throw new BadCredentialsException("External system authentication failed");
			}
		} catch (Exception e) {
			throw new BadCredentialsException("External system authentication failed");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
