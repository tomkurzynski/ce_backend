package com.createvent.createvent.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createvent.createvent.dto.UserRegDto;
import com.createvent.createvent.entity.Users;
import com.createvent.createvent.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
		@Autowired
	    private UserService userService;
		
	    private Logger logger = Logger.getLogger(getClass().getName());
	    
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}	

		@PostMapping("/processRegistrationForm")
		public void processRegistrationForm(
					@Valid @ModelAttribute("crmUser") UserRegDto theCrmUser, 
					BindingResult theBindingResult, 
					Model theModel) {
			
			String userName = theCrmUser.getEmail();
			logger.info("Processing registration form for: " + userName);
			
			// form validation
			 if (theBindingResult.hasErrors()){
//				 return "registration-form";
		        }

			// check the database if user already exists
	        Users existing = userService.getByEmail(userName);
	        if (existing != null){
	        	theModel.addAttribute("crmUser", new UserRegDto());
				theModel.addAttribute("registrationError", "User name already exists.");

				logger.warning("User name already exists.");
//	        	return "registration-form";
	        }
	        
	        // create user account        						
	        userService.save(theCrmUser);
	        
	        logger.info("Successfully created user: " + userName);
	        
	     	
		}

}
