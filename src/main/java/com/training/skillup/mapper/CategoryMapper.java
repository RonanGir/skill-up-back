package com.training.skillup.mapper;

import java.util.Set;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.CategoryBean;
import com.training.skillup.entity.CategoryEntity;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

	@Named("toBean")
	@Mapping(target = "tags", ignore = true)
	CategoryBean categoryEntitytoCategoryBean(CategoryEntity category);

	@Named("toEntity")
	@Mapping(target = "tags", ignore = true)
	CategoryEntity categoryBeantoCategoryEntity(CategoryBean category);

	@Named("toBeans")
	@IterableMapping(qualifiedByName = "toBean")
	Set<CategoryBean> categoryEntitiestoCategoryBeans(Set<CategoryEntity> categories);

	@Named("toEntities")
	@IterableMapping(qualifiedByName = "toEntity")
	Set<CategoryEntity> categoryBeanstoCategoryEntities(Set<CategoryBean> categories);


}
