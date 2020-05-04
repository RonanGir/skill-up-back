package com.training.skillup.bean;

import lombok.Data;

@Data
public class UserBean {

	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private ProfileBean profile;

}
