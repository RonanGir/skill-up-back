package com.training.skillup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.skillup.entity.ProfileEntity;
import com.training.skillup.service.repository.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;

	public List<ProfileEntity> findProfiles() {
		return profileRepo.findAll();
	}

}
