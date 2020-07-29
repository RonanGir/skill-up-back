package com.training.skillup.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.training.skillup.bean.ProfileBean;
import com.training.skillup.entity.ProfileEntity;

class ProfileMapperTest {

	@Mock
	ProfileMapper mapper;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldMapProfileEntityToBean() {
		// Init User Profil Entity
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setId(1L);
		profileEntity.setName("ADMIN");

		//when
		ProfileBean profileBean = mapper.profileEntityToProfileBean(profileEntity);

		//then
		assertEquals(profileBean.getName().name(), profileEntity.getName());

	}

}
