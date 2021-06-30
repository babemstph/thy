package org.sid.web;

import java.security.Principal;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.sid.model.User;

import org.sid.repository.UserRepository;

import org.sid.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
  
    @Autowired
    UserRepository userRepository;
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
		
	}
	
	
	
	
	
	@RequestMapping(value="/registration")
	//@GetMapping
	public String showRegistrationForm() {
		
		//model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	//@PostMapping
	@RequestMapping(value="/SAve",method=RequestMethod.POST)
	public String registrationUserAccount( @Valid User registrationDto,@RequestParam(name="typeUser") String t,BindingResult bindingResult) {
		User user=userRepository.findByEmail(registrationDto.getEmail());
		if(user != null) {
			return "redirect:/registration?error";
		}
		if(bindingResult.hasErrors()) {
			return "/registration";
		}
		userService.Save(registrationDto,t);
		return "redirect:/registration?success";
	}
	
	//@GetMapping("/")
	@RequestMapping(value="/")
	public String home() {
		
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		
		return "login";
	}
	


	
	
	
	
	
	
	
}
