package cz.vutbr.feec.seda.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import cz.vutbr.feec.seda.dao.UserRepository;
import cz.vutbr.feec.seda.entity.Scenario;
import cz.vutbr.feec.seda.entity.User;
import cz.vutbr.feec.seda.security.AESCipher;
import cz.vutbr.feec.seda.service.UserService;
import cz.vutbr.feec.seda.service.UserServiceImpl;

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
	public void testAuthenticate() {
		userService.authenticate(u1, "password");
		try {
			verify(aesCipher, times(1)).validatePassword(any(String.class),
					any(String.class));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
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
