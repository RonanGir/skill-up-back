package com.training.skillup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.skillup.config.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SkillupApplication {

	@Autowired
	private Config myConfig;

	public static void main(String[] args) {
		SpringApplication.run(SkillupApplication.class, args);
	}

}
