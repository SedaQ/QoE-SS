package com.seda.qoe.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.dao.UserRepository;
import com.seda.qoe.entity.User;

/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = com.seda.qoe.test.context.PersistenceApplicationContextTest.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class UserRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UserRepository userRepository;

	private User user1;
	private User user2;

	@BeforeMethod
	public void beforeMethod() {
		user1 = new User();
		user1.setEmail("pavelseda@email.cz");
		user1.setPasswordHash("pavel");

		user2 = new User();
		user2.setEmail("pavelseda2@email.cz");
		user2.setPasswordHash("pavel2");

	}

	@AfterMethod
	public void afterMethod() {
		userRepository.deleteAll();
	}

	@Test
	public void testCreate() {
		userRepository.save(user1);
		userRepository.save(user2);
		Assert.assertNotNull(em.find(User.class, user1.getId()));
		Assert.assertNotNull(em.find(User.class, user2.getId()));
	}

	@Test
	public void testGetAll() {
		userRepository.save(user1);
		userRepository.save(user2);
		Assert.assertEquals(userRepository.findAll().size(), 2);
	}

	@Test
	public void testUpdate() {
		userRepository.save(user1);
		user1.setEmail("pavelsedatempemail@email.cz");
		userRepository.save(user1);
		Assert.assertEquals(em.find(User.class, user1.getId()).getEmail(),
				user1.getEmail());
	}

	@Test
	public void testRemove() {
		em.persist(user1);
		Assert.assertNotNull(em.find(User.class, user1.getId()));
		userRepository.delete(user1);
		Assert.assertNull(em.find(User.class, user1.getId()));
	}
}
