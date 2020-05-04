package com.training.skillup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.skillup.bean.DashboardBean;
import com.training.skillup.bean.UserBean;
import com.training.skillup.service.DashboardService;
import com.training.skillup.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api", produces = "application/json", consumes = "application/json")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	DashboardService dashService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserBean> getUsers() {
		List<UserBean> users = userService.findUsers();
		return users;
	}

	@RequestMapping(value = "/user/board", method = RequestMethod.POST)
	public DashboardBean getUserBoard(@RequestBody UserBean user) {
		return dashService.findDashboardByUser(user);
	}

}
