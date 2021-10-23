package com.warm.blog.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warm.blog.start.entity.Post;
import com.warm.blog.start.entity.User;
@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

}
