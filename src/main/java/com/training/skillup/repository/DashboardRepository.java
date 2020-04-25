package com.training.skillup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.skillup.entity.DashboardEntity;
import com.training.skillup.entity.UserEntity;

@Repository
public interface DashboardRepository extends JpaRepository<DashboardEntity, Long> {

	DashboardEntity findByUser(UserEntity user);

}
