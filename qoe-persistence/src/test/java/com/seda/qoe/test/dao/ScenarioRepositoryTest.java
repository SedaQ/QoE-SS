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

import com.seda.qoe.dao.ScenarioRepository;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.entity.Scenario;

/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContextTest.class)
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
		scenarioDao.deleteAll();
	}

	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Scenario.class, scenario.getId()));
	}

	@Test
	public void testFindAll() {
		Assert.assertNotNull(scenarioDao.findAll());
	}

	@Test
	public void testFindById() {
		Assert.assertNotNull(scenarioDao.findOne(scenario.getId()));
	}

	@Test
	public void testUpdate() {
		scenario.setScenario("scenarioupdated2");
		scenarioDao.save(scenario);
		Assert.assertEquals(scenario.getScenario(),
				scenarioDao.findOne(scenario.getId()).getScenario());
	}

	@Test
	public void testRemove() {
		Assert.assertNotNull(em.find(Scenario.class, scenario.getId()));
		scenarioDao.delete(scenario);
		Assert.assertNull(em.find(Scenario.class, scenario.getId()));
	}

}
