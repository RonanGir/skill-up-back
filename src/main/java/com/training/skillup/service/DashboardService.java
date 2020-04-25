package com.training.skillup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.skillup.entity.DashboardEntity;
import com.training.skillup.entity.UserEntity;
import com.training.skillup.repository.DashboardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DashboardService {

	@Autowired
	DashboardRepository dashRepo;

	public DashboardEntity findDashboardByUser(UserEntity user) {
		return dashRepo.findByUser(user);
	}

}
