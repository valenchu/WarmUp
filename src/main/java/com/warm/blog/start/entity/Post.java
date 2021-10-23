package com.warm.blog.start.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SQLDelete(sql = "UPDATE `post` c SET deleted = true WHERE ID = ? ")
@Where(clause = "deleted = false")
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String title;
	@Length(max = 2000000)
	private String content;
	private String img;
	private String category;
	@DateTimeFormat
	private LocalDate date;
	private Boolean deleted;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "user_id")
	private User user;
}
