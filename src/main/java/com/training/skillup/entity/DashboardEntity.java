package com.training.skillup.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(
		name = "dashboard", schema = "skillupdb"
		)
public class DashboardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "ass_dashboard_tutorial", 
			joinColumns = { @JoinColumn(name = "dashboard_id", referencedColumnName = "id") }, 
			inverseJoinColumns = { @JoinColumn(name = "tutorial_id", referencedColumnName = "id") }
			)
	private Set<TutorialEntity> tutorials = new HashSet<>();
}
