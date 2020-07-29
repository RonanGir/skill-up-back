package com.training.skillup.mapper;

import java.util.IdentityHashMap;
import java.util.Map;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

import liquibase.pro.packaged.T;

public class ContextMapping {
	private Map<Object, Object> knownInsances = new IdentityHashMap<>();

	@BeforeMapping
	public <T> T getMappedInstance(final Object source, @TargetType Class<T> targetType) {
		return (T) knownInsances.get(source);
	}

	@BeforeMapping
	public void storeMappedInstance(final Object source, @MappingTarget Class<T> target) {
		knownInsances.put(source, target);
	}

}
