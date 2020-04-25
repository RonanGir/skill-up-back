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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
		name = "tutorial", schema = "skillupdb"
)
public class TutorialEntity {
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	private Long id;

	private String title;

	private String url;

	private String description;

	@ManyToMany(
			fetch = FetchType.EAGER
	)
	@JoinTable(
			name = "ass_tutorial_tag", joinColumns = { @JoinColumn(
					name = "tutorial_id", referencedColumnName = "id"
			) }, inverseJoinColumns = { @JoinColumn(
					name = "tag_id", referencedColumnName = "id"
			) }
	)
	private Set<TagEntity> tags = new HashSet<>();

	@ManyToMany(
			fetch = FetchType.EAGER
	)
	@JoinTable(
			name = "ass_dashboard_tutorial", joinColumns = { @JoinColumn(
					name = "tutorial_id", referencedColumnName = "id"
			) }, inverseJoinColumns = { @JoinColumn(
					name = "dashboard_id", referencedColumnName = "id"
			) }
	)
	@JsonIgnore
	private Set<DashboardEntity> dashboards = new HashSet<>();
}
