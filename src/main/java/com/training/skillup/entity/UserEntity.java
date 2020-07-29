package com.training.skillup.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "app_user", schema = "skillupdb")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 35)
	private String firstname;

	@JsonIgnore
	@Column(length = 35)
	private String lastname;

	@Column(length = 55)
	private String username;

	@Column(length = 55)
	private String email;

	@Column(length = 35)
	@JsonIgnore
	private String password;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id")
	private ProfileEntity profile;

	/*
	 * Clone method
	 */
	public UserEntity(UserEntity user) {
		this.id = user.id;
		this.firstname = user.firstname;
		this.lastname = user.lastname;
		this.username = user.username;
		this.email = user.email;
		this.password = user.password;
		this.profile = user.profile;
	}



}
