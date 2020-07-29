package com.training.skillup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.ProfileBean;
import com.training.skillup.entity.ProfileEntity;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

	public ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

	ProfileBean profileEntityToProfileBean(ProfileEntity profile);

	ProfileEntity profileBeanToProfileEntity(ProfileBean profile);

}
