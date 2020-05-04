package com.training.skillup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.skillup.bean.UserBean;
import com.training.skillup.entity.UserEntity;
import com.training.skillup.mapper.UserMapper;
import com.training.skillup.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserMapper userMap;

	@Autowired
	UserRepository userRepo;

	public List<UserBean> findUsers() {
		List<UserEntity> userEntities = userRepo.findAll();
		return userMap.userEntitiesToUserBeans(userEntities);
	}

}
