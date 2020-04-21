package com.createvent.createvent.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.createvent.createvent.validation.FieldMatch;
import com.createvent.createvent.validation.ValidEmail;

import lombok.Data;

@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
@Data
public class UserRegDto {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String confirmPassword;
	
	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String email;
}
