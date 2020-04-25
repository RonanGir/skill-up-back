package com.training.skillup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.skillup.entity.UserEntity;
import com.training.skillup.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public List<UserEntity> findUsers() {
		return userRepo.findAll();
	}

}
