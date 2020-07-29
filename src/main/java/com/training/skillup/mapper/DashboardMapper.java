package com.training.skillup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.DashboardBean;
import com.training.skillup.entity.DashboardEntity;

@Component
@Mapper(
		componentModel="spring", 
		unmappedTargetPolicy = ReportingPolicy.IGNORE, 
		uses = { TutorialMapper.class })
public interface DashboardMapper {

	public DashboardMapper INSTANCE = Mappers.getMapper(DashboardMapper.class);

	@Mapping(target = "tutorials", qualifiedByName = "toBeans")
	DashboardBean dashboardEntityToDashboardBean(DashboardEntity dashboard);

	@Mapping(target = "tutorials", qualifiedByName = "toEntities")
	DashboardEntity dashboardBeanToDashboardEntity(DashboardBean dashboard);
}
