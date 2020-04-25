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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
		name = "tag", schema = "skillupdb"
)
public class TagEntity {

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
	)
	private Long id;

	private String name;

	@ManyToOne(
			fetch = FetchType.EAGER
	)
	@JoinColumn(
			name = "category_id"
	)
	private CategoryEntity category;

	@ManyToMany(
			fetch = FetchType.EAGER
	)
	@JoinTable(
			name = "ass_tutorial_tag", joinColumns = { @JoinColumn(
					name = "tag_id"
			) }, inverseJoinColumns = { @JoinColumn(
					name = "tutorial_id"
			) }
	)
	@JsonIgnore
	private Set<TutorialEntity> tutorials = new HashSet<>();

}
