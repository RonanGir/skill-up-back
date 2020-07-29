package com.training.skillup.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.skillup.entity.UserEntity;
import com.training.skillup.repository.UserRepository;
import com.training.skillup.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		UserEntity user = userRepo.findByEmail(email);

		if (user == null) {
			log.info(Constant.USER_NOT_FOUND);
			throw new UsernameNotFoundException(Constant.USER_NOT_FOUND);
		}

		return new AppUserPrincipal(user);
	}

	public Boolean passwordMatch(String password, String encodedPassword) {
		return encoder.matches(password, encodedPassword);
	}

}
