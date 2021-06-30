package org.sid.service;

import java.util.Arrays;

import java.util.Collection;
import java.util.stream.Collectors;

import org.sid.model.Role;
import org.sid.model.User;
import org.sid.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
   
	@Autowired 
	private  UserRepository userRepository;
	
	
	 @Autowired BCryptPasswordEncoder passwordEncoder;
	 

	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User Save(User user,String typeUser) {
		User user1=new User(user.getNom(), user.getPrenom(),user.getEmail(),passwordEncoder.encode(user.getPassword()),
				Arrays.asList(new Role(typeUser)));
		
		return userRepository.save(user1);
	}

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =userRepository.findByEmail(username);
		if(user ==null) {
			throw new UsernameNotFoundException("invalid user name or password");
			
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		 
	}

}




