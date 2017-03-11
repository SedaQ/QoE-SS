package com.seda.qoe.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.dao.UserRepository;
import com.seda.qoe.entity.Scenario;
import com.seda.qoe.entity.User;
import com.seda.qoe.security.AESCipher;

public class UserServiceTest {

	@Mock
	private UserRepository userDao;

	@Mock
	private UserService userService;

	@Mock
	private AESCipher aesCipher;

	private User u1;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userDao, aesCipher);
	}

	@BeforeMethod
	public void beforeMethod() {
		u1 = new User();
		u1.setEmail("pavelseda@emailcz");
		u1.setPasswordHash("passwordHash");
	}

	@AfterMethod
	public void afterMethod() {
		reset(userDao);
	}

	@Test
	public void testCreate() {
		userService.registerUser(u1, "password");
		verify(userDao, times(1)).save(any(User.class));
	}

	@Test
	public void testUpdate() {
		userService.update(u1);
		verify(userDao, times(1)).save(any(User.class));
	}

	@Test
	public void testFindById() {
		userService.findById(1L);
		verify(userDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		userService.findAll("");
		verify(userDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		userService.findAll("age==17");
		verify(userDao, times(1)).findAll(any(Specification.class));
	}

	@Test
	public void testRemove() {
		userService.remove(u1);
		verify(userDao, times(1)).delete(any(User.class));
	}
}
