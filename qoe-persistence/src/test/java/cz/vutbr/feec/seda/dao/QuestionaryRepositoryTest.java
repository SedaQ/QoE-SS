package cz.vutbr.feec.seda.dao;

import java.util.Date;

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

import cz.vutbr.feec.seda.dao.QuestionaryRepository;
import cz.vutbr.feec.seda.entity.Questionary;

/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = cz.vutbr.feec.seda.context.PersistenceApplicationContextTest.class)
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
		questionary.setDate(new Date());
		questionary.setEmail("pavelseda@eeeeeeeeetest.cz");
		questionary.setGender("muz");
		questionary.setSchool("stredni_skola");
		questionary.setUserConnection("wifi_pripojeni");
		questionaryDao.save(questionary);
	}

	@AfterMethod
	public void afterMethod() {
		questionaryDao.deleteAll();
	}

	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Questionary.class, questionary.getId()));
	}

	@Test
	public void testFindAll() {
		Assert.assertNotNull(questionaryDao.findAll());
	}

	@Test
	public void testFindById() {
		Assert.assertNotNull(questionaryDao.findOne(questionary.getId()));
	}

	@Test
	public void testUpdate() {
		questionary.setEmail("pavelsedaupdatedemail@seznam.cz");
		questionaryDao.save(questionary);
		Assert.assertEquals(questionary.getEmail(),
				questionaryDao.findOne(questionary.getId()).getEmail());
	}

	@Test
	public void testRemove() {
		Assert.assertNotNull(em.find(Questionary.class, questionary.getId()));
		questionaryDao.delete(questionary);
		Assert.assertNull(em.find(Questionary.class, questionary.getId()));
	}

}
