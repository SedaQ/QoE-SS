package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.seda.qoe.dto.user.UserCreateDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.entity.User;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.UserService;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Service
@Transactional
public class UserFacadeImpl implements UserFacade {

	private UserService userService;
	private BeanMapping beanMapping;

	@Inject
	public UserFacadeImpl(UserService userService, BeanMapping beanMapping) {
		this.userService = userService;
		this.beanMapping = beanMapping;
	}

	@Override
	public UserDTO getUserById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			User user = userService.findById(id);
			return user != null ? beanMapping.mapTo(user, UserDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public UserDTO update(Long userId) {
		if (userId == null)
			throw new IllegalArgumentException(
					"userId parameter is null in update method");
		try {
			User user = userService.update(userService.findById(userId));
			return user != null ? beanMapping.mapTo(user, UserDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteUser(Long userId) {
		if (userId == null)
			throw new IllegalArgumentException(
					"userId parameter is null in deleteUser method");
		try {
			userService.remove(userService.findById(userId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<UserDTO> getAllUsers(String search) {
		try {
			return beanMapping.mapTo(userService.findAll(search), UserDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		if (email == null || email.isEmpty())
			throw new IllegalArgumentException(
					"email parameter is null or empty");
		try {
			User user = userService.findByEmail(email);
			if (user != null)
				return beanMapping.mapTo(user, UserDTO.class);
			else
				return null;

		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean registerUser(UserCreateDTO u, String unencryptedPassword) {
		if (u == null || unencryptedPassword == null
				|| unencryptedPassword.isEmpty())
			throw new IllegalArgumentException(
					"u parameter is null or unencryptedPassword is null or unencryptedPassword is empty in registerUser method");
		try {
			User userEntity = beanMapping.mapTo(u, User.class);
			userService.registerUser(userEntity, unencryptedPassword);
			u.setId(userEntity.getId());
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public Boolean authenticate(UserDTO u) {
		if (u == null)
			throw new IllegalArgumentException(
					"UserDTO u parametr is null in authenticate method");
		try {
			return userService.authenticate(userService.findById(u.getId()),
					u.getPasswordHash());
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public boolean isAdmin(UserDTO u) {
		if (u == null)
			throw new IllegalArgumentException(
					"UserDTO u parametr is null in isAdmin method");
		try {
			Boolean isAdminBool = userService.isAdmin(beanMapping.mapTo(u,
					User.class));
			return isAdminBool != null ? isAdminBool.booleanValue() : false;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

}
