package com.seda.qoe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.entity.Questionary;

@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class QuestionaryRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private QuestionaryRepository questionaryDao;

	private Questionary questionary;

	@BeforeMethod
	public void beforeMethod() {
		questionary = new Questionary();
		questionary.setAge("24");
		questionary.setEmail("pavelseda@eeeeeeeeetest.cz");
		questionary.setGender("muz");
		questionary.setSchool("stredni_skola");
		questionary.setUserConnection("wifi_pripojeni");
		questionaryDao.save(questionary);
	}

	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Questionary.class, questionary.getId()));
	}

	@Test
	public void testFindAll() {
		Assert.assertNotNull(questionaryDao.findAll());
	}

}
