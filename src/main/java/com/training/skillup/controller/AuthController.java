package com.training.skillup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.skillup.bean.CredentialBean;
import com.training.skillup.config.security.UserDetailsServiceImpl;
import com.training.skillup.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AuthController {

	@Autowired
	UserDetailsServiceImpl loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST) 
	public UserDetails login(@RequestBody CredentialBean credentials) throws Exception {
		UserDetails user = loginService.loadUserByUsername(credentials.getEmail());
		if (!loginService.passwordMatch(credentials.getPassword(), user.getPassword())) {
			throw new Exception(Constant.WRONG_PASSWORD);
		}
		return user;
	}
}
