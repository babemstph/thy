package org.sid.service;

import org.sid.model.User;



import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	
	User Save( User registrationDto,String typeUser);

}
