package com.warm.blog.start.security.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.warm.blog.start.entity.User;
import com.warm.blog.start.repository.UserRepo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserMapper mapper;
	@Autowired
	private SendGridService sendGridService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username = "user";
		// Obtain the user to user DB
		User u = userRepo.findByUserEmail(username);
		String usernameRepo = u.getUserEmail();
		String pass = u.getPassword();

		if (username != null) {
			if (usernameRepo.equalsIgnoreCase(username)) {

				return new User(usernameRepo, pass, Collections.emptyList());

			} else {
				throw new UsernameNotFoundException("Username or Password ICORRECT");
			}
		} else {
			throw new UsernameNotFoundException("Username or Password ICORRECT");
		}
	}

	public void saveUser(UserDto userDto, String pass) {
		UserEntity user = mapper.authentication2User(userDto);
		if (user.getUser() != null && !user.getUser().isEmpty()) {

			sendGridService.senEmail(user.getUser(), mapper.htmlWelcome(user.getUser(), pass));
		}
		userRepo.save(user);

	}

}
