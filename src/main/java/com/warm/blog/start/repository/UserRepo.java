package com.warm.blog.start.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warm.blog.start.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findByUserEmail(String userEmail);

}
