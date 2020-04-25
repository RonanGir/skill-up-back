package com.training.skillup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.skillup.entity.TutorialEntity;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialEntity, Long> {

}
