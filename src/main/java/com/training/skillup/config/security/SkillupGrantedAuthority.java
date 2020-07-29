package com.training.skillup.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.training.skillup.entity.ProfileEntity;

@Component
public class SkillupGrantedAuthority extends ProfileEntity implements GrantedAuthority {

	@Override
	public String getAuthority() {
		return getName();
	}

}
