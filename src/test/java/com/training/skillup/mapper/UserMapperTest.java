package com.training.skillup.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.training.skillup.bean.ProfileBean;
import com.training.skillup.bean.ProfileType;
import com.training.skillup.bean.UserBean;
import com.training.skillup.entity.ProfileEntity;
import com.training.skillup.entity.UserEntity;

class UserMapperTest {

	private ProfileEntity profileEntity = new ProfileEntity();
	private UserEntity userEntity = new UserEntity();
	private ProfileBean profileBean = new ProfileBean();
	private UserBean userBean = new UserBean();

	@Mock
	UserMapper mapper;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		initData();
	}

	public void initData() {
		// Init User Profil Entity
		profileEntity.setId(1L);
		profileEntity.setName("ADMIN");

		// Init User Entity
		userEntity.setId(1L);
		userEntity.setFirstname("Ronan");
		userEntity.setLastname("Girault");
		userEntity.setUsername("Ronangir");
		userEntity.setEmail("ronangir@skillup.io");
		userEntity.setPassword("password");

		// Init User Profil Bean
		profileBean.setId(1L);
		profileBean.setName(ProfileType.ADMIN);

		// Init User Bean
		userBean.setId(1L);
		userBean.setFirstname("Ronan");
		userBean.setLastname("Girault");
		userBean.setUsername("Ronangir");
		userBean.setEmail("ronangir@skillup.io");
		userBean.setPassword("password");


	}

	@Test
	public void shouldMapUserEntityToBean() {
		// Set the profile Entity
		userEntity.setProfile(profileEntity);

		//when
		UserBean userBeanReturned = mapper.userEntityToUserBean(userEntity);

		//then
		assertEquals(userBeanReturned.getId(), userEntity.getId());
		assertEquals(userBeanReturned.getUsername(), userEntity.getUsername());
		assertEquals(userBeanReturned.getFirstname(), userEntity.getFirstname());
		assertEquals(userBeanReturned.getLastname(), userEntity.getLastname());
		assertEquals(userBeanReturned.getEmail(), userEntity.getEmail());
		assertEquals(userBeanReturned.getPassword(), userEntity.getProfile());
		assertEquals(userBeanReturned.getProfile().getName().toString(), userEntity.getProfile().getName());

	}

	@Test
	public void shouldMapUserBeanToEntity() {
		// Set the profile Entity
		userBean.setProfile(profileBean);

		//when
		UserEntity userEntityReturned = UserMapper.INSTANCE.userBeanToUserEntity(userBean);

		//then
		assertEquals(userEntityReturned.getId(), userBean.getId());
		assertEquals(userEntityReturned.getUsername(), userBean.getUsername());
		assertEquals(userEntityReturned.getFirstname(), userBean.getFirstname());
		assertEquals(userEntityReturned.getLastname(), userBean.getLastname());
		assertEquals(userEntityReturned.getEmail(), userBean.getEmail());
		assertEquals(userEntityReturned.getPassword(), userBean.getProfile());
		assertEquals(userEntityReturned.getProfile().getName(), userBean.getProfile().getName().name());

	}

}
