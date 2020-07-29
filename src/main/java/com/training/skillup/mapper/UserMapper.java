package com.training.skillup.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.training.skillup.bean.UserBean;
import com.training.skillup.entity.UserEntity;

@Component
@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	public final static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "password", ignore = true)
	@Named("toBean")
	UserBean userEntityToUserBean(UserEntity user);

	@Mapping(target = "password", ignore = true)
	@Named("toEntity")
	UserEntity userBeanToUserEntity(UserBean user);

	@IterableMapping(qualifiedByName = "toBean")
	List<UserBean> userEntitiesToUserBeans(List<UserEntity> users);

	@IterableMapping(qualifiedByName = "toEntity")
	List<UserEntity> userBeansToUserEntities(List<UserBean> users);


}
