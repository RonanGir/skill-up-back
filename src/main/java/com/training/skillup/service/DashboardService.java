package com.training.skillup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.skillup.bean.DashboardBean;
import com.training.skillup.bean.UserBean;
import com.training.skillup.entity.DashboardEntity;
import com.training.skillup.entity.UserEntity;
import com.training.skillup.mapper.DashboardMapper;
import com.training.skillup.mapper.UserMapper;
import com.training.skillup.repository.DashboardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DashboardService {

	@Autowired
	UserMapper userMap;

	@Autowired
	DashboardMapper dashMap;

	@Autowired
	UserService userService;

	@Autowired
	DashboardRepository dashRepo;

	public DashboardBean findDashboardByUser(UserBean user) {
		UserEntity userEntity = userService.findUserByEmail(user.getEmail());
		DashboardEntity dashEntity = dashRepo.findByUser(userEntity);
		return dashMap.dashboardEntityToDashboardBean(dashEntity);

	}

}
