package com.training.skillup.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.TutorialBean;
import com.training.skillup.entity.TutorialEntity;

@Component
@Mapper(
		componentModel="spring", 
		unmappedTargetPolicy = ReportingPolicy.IGNORE,
		uses = TagMapper.class)
public interface TutorialMapper {

	@Named("toBean")
	@Mapping(target = "dashboards", ignore = true)
	@Mapping(target = "tags", qualifiedByName = "toBeans")
	TutorialBean tutorialEntitytoTutorialBean(TutorialEntity tutorial);

	@Named("toEntity")
	@Mapping(target = "dashboards", ignore = true)
	@Mapping(target = "tags", qualifiedByName = "toEntities")
	TutorialEntity tutorialBeantoTutorialEntity(TutorialBean tutorial);

	@Named("toBeans")
	@IterableMapping(qualifiedByName = "toBean")
	Set<TutorialBean> tutorialEntitiestoTutorialBeans(Set<TutorialEntity> tutorials);

	@Named("toEntities")
	@IterableMapping(qualifiedByName = "toEntity")
	Set<TutorialEntity> tutorialBeanstoTutorialEntities(Set<TutorialBean> tutorials);

}
