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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.entity.Mos;
import com.seda.qoe.entity.Scenario;

@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ScenarioRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ScenarioRepository scenarioDao;

	private Scenario scenario;

	@BeforeMethod
	public void beforeMethod() {
		scenario = new Scenario();
		scenario.setScenario("scenarioxyz120310310230");
		scenarioDao.save(scenario);
	}

	@AfterMethod
	public void afterMethod() {

	}

	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Scenario.class, scenario.getId()));
	}

	@Test
	public void testFindAll() {
		Assert.assertNotNull(scenarioDao.findAll());
	}

}
