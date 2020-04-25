package com.training.skillup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.skillup.entity.DashboardEntity;
import com.training.skillup.entity.UserEntity;
import com.training.skillup.service.DashboardService;
import com.training.skillup.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(
	"http://localhost:4200"
)
@RequestMapping(
		value = "/api"
)
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	DashboardService dashService;

	@RequestMapping(
			value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE
	)
	public String sayHello() {
		String greeting = "Coucou toi";
		return greeting;
	}

	@RequestMapping(
			value = "/users", method = RequestMethod.GET
	)
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userService.findUsers();
		return users;
	}

	@RequestMapping(
			value = "/user/board", method = RequestMethod.POST
	)
	public DashboardEntity getUserBoard(@RequestBody UserEntity user) {
		return dashService.findDashboardByUser(user);
	}

}
