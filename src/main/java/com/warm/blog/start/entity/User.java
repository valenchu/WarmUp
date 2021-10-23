package com.warm.blog.start.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
@SQLDelete(sql = "UPDATE `User` c SET deleted = true WHERE ID = ? ")
@Where(clause = "deleted = false")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Column(name = "user_email")
	@Email
	private String userEmail;
	
	private String password;

	private Boolean deleted = Boolean.FALSE;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Post> post = new ArrayList<>();
}
