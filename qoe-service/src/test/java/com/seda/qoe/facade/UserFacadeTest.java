package com.seda.qoe.facade;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.config.BeanMappingConfiguration;
import com.seda.qoe.dto.user.UserCreateDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.entity.User;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.UserService;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UserFacadeTest extends AbstractTestNGSpringContextTests {

	@Mock
	private UserService userService;
	@Mock
	private BeanMapping beanMapping;

	private UserFacade userFacade;
	private UserDTO userDTO;
	private UserCreateDTO userCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new User()).when(beanMapping).mapTo(any(UserDTO.class),
				eq(User.class));

		userFacade = new UserFacadeImpl(userService, beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		userDTO = new UserDTO();
		userCreateDTO = new UserCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(userService);
	}

	@Test
	public void testCreate() {
		userFacade.registerUser(userCreateDTO, "testpassworduser");
		verify(userService, times(1)).registerUser(any(User.class),
				any(String.class));
	}

	@Test
	public void testAuthenticate() {
		userFacade.authenticate(userDTO);
		verify(userService, times(1)).authenticate(any(User.class),
				any(String.class));
	}

	@Test
	public void testUpdate() {
		userFacade.update(1L);
		verify(userService, times(1)).update(any(User.class));
	}

	@Test
	public void testFindById() {
		userFacade.getUserById(Long.MAX_VALUE);
		verify(userService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		userFacade.getAllUsers("");
		verify(userService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testRemove() {
		userFacade.deleteUser(Long.MAX_VALUE);
		verify(userService, times(1)).remove(any(User.class));
	}
}
