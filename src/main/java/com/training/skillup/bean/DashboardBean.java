package com.training.skillup.bean;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class DashboardBean {

	private Long id;
	private UserBean user;
	private Set<TutorialBean> tutorials = new HashSet<>();

}
