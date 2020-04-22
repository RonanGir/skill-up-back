package com.training.skillup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user", schema = "skillupdb")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 35)
	private String firstname;

	@Column(length = 35)
	private String lastname;

	@Column(length = 55)
	private String username;

	@Column(length = 55)
	private String email;

	@Column(length = 35)
	private String password;

	@ManyToOne
	private ProfileEntity profile;

}
