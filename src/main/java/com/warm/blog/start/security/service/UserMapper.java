package com.warm.blog.start.security.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.movie.start.security.dto.UserDto;
import com.movie.start.security.entity.UserEntity;

@Component
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder encoder;

	public UserEntity authentication2User(UserDto userDto) {
		String pass = encoder.encode(userDto.getPassword());
		userDto.setPassword(pass);

		return modelMapper.map(userDto, UserEntity.class);
	}

	public String htmlWelcome(String email, String pass) {
		String html = "<html>" + "<head>" + "<style>" + "h1 {text-align: center;}" + "</style>" + "</head>" + "<body>"

				+ "<h1>" + "WELCOME TO APLICATION MOVIE" + "</h1>" + 
				"<br/>" 
				+ "<h2>" + "Your data is USER: " + email + " PASS: " + pass
				+ "</body>" + "</html>";
		return html;
	}

}
