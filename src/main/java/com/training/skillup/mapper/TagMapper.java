package com.training.skillup.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.TagBean;
import com.training.skillup.entity.TagEntity;

@Component
@Mapper(
		componentModel="spring", 
		unmappedTargetPolicy = ReportingPolicy.IGNORE, 
		uses = { CategoryMapper.class })
public interface TagMapper {

	@Named("toBean")
	@Mapping(target = "tutorials", ignore = true)
	@Mapping(target = "category", qualifiedByName = "toBean")
	TagBean tagEntitytoTagBean(TagEntity tag);

	@Named("toEntity")
	@Mapping(target = "tutorials", ignore = true)
	@Mapping(target = "category", qualifiedByName = "toEntity")
	TagEntity tagBeantoTagEntity(TagBean tag);

	@Named("toBeans")
	@IterableMapping(qualifiedByName = "toBean")
	Set<TagBean> tagEntitiestoTagBeans(Set<TagEntity> tags);

	@Named("toEntities")
	@IterableMapping(qualifiedByName = "toEntity")
	Set<TagEntity> tagBeanstoTagEntities(Set<TagBean> tags);

}
