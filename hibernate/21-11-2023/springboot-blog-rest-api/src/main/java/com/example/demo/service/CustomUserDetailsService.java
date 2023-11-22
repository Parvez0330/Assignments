package com.example.demo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service


public class CustomUserDetailsService implements UserDetailsService {

	
	private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
          User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
          //If the user is not found in the database, it throws a UsernameNotFoundException with 
          //a specific error message indicating that the user was not found.

        Set<GrantedAuthority> authorities = user
                .getRoles()
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
        
        //retrieves the roles associated with the found user, converts them into GrantedAuthority objects (typically used for permissions), 
        //and collects them into a Set. 
        //This set of authorities will be used to configure the user's roles.

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                authorities);
                //Finally, it constructs and returns a UserDetails object. .
                //This object is often used by Spring Security to represent the authenticated user.
    }
	
	
	
}
