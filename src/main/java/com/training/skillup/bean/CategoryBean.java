package com.training.skillup.bean;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CategoryBean {

	private Long id;
	private String name;
	@JsonIgnore
	private Set<TagBean> tags = new HashSet<>();

}
