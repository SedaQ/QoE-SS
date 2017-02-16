package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.UserRepository;
import com.seda.qoe.entity.User;
import com.seda.qoe.enums.UserRoles;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.security.UserPasswordEncryption;

/**
 * @author Pavel Šeda
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userDao;

	private UserPasswordEncryption userPasswordEncryption;

	@Inject
	public UserServiceImpl(UserRepository userDao, UserPasswordEncryption userPasswordEncryption) {
		this.userDao = userDao;
		this.userPasswordEncryption = userPasswordEncryption;
	}

	@Override
	public void registerUser(User u, String unencryptedPassword) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		if (unencryptedPassword == null)
			throw new IllegalArgumentException("String unencryptedPassword parameter is null");

		try {
			u.setPasswordHash(userPasswordEncryption.createHash(unencryptedPassword));
			userDao.save(u);
		} catch (RuntimeException ex) {
			throw new ServiceLayerException("Problem with registering LS-User, see inner exception.", ex);
		}
	}

	@Override
	public boolean authenticate(User u, String password) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		if (password == null)
			throw new IllegalArgumentException("String password parameter is null");

		try {
			return userPasswordEncryption.validatePassword(password, u.getPasswordHash());
		} catch (RuntimeException ex) {
			throw new ServiceLayerException("Problem with authenticating User, see inner exception.", ex);
		}
	}

	@Override
	public User findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return userDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public User update(User c) {
		if (c == null)
			throw new IllegalArgumentException("User c parameter is null");

		try {
			return userDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating User, see inner exception.", ex);
		}
	}

	@Override
	public void remove(User c) {
		if (c == null)
			throw new IllegalArgumentException("User c parameter is null");
		try {
			userDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting User, see inner exception.", ex);
		}
	}

	@Override
	public List<User> findAll() {
		try {
			return userDao.findAll();
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public User findByEmail(String email) {
		if (email == null)
			throw new IllegalArgumentException("String email parameter is null");

		try {
			return userDao.findByEmail(email);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

	@Override
	public boolean isAdmin(User u) {
		if (u == null)
			throw new IllegalArgumentException("User u parameter is null");
		try {
			return userDao.findByEmail(u.getEmail()).getRoles().equals(UserRoles.ROLE_ADMIN.name());
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding User, see inner exception.", ex);
		}
	}

}
