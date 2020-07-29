package com.training.skillup.bean;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TutorialBean {

	private Long id;
	private String title;
	private String url;
	private String description;
	private Set<TagBean> tags = new HashSet<>();

	@JsonIgnore
	private Set<DashboardBean> dashboards = new HashSet<>();

}
