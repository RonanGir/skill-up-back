package com.training.skillup.bean;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class TagBean {

	private Long id;
	private String name;
	private CategoryBean category;

	@JsonIgnore
	private Set<TutorialBean> tutorials = new HashSet<>();

}
