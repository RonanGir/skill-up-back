package com.training.skillup.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserBean {

	private Long id;

	private String firstname;

	@JsonIgnore
	private String lastname;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private ProfileBean profile;

}
