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

import cz.vutbr.feec.seda.dao.MosRepository;
import cz.vutbr.feec.seda.dao.QuestionaryRepository;
import cz.vutbr.feec.seda.dao.ScenarioRepository;
import cz.vutbr.feec.seda.dao.VideoRepository;
import cz.vutbr.feec.seda.entity.Mos;
import cz.vutbr.feec.seda.entity.Questionary;
import cz.vutbr.feec.seda.entity.Scenario;
import cz.vutbr.feec.seda.entity.ScenarioParameters;
import cz.vutbr.feec.seda.entity.Video;

/**
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = cz.vutbr.feec.seda.context.PersistenceApplicationContextTest.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MosRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private MosRepository mosDao;
	@Autowired
	private VideoRepository videoDao;
	@Autowired
	private QuestionaryRepository questionaryDao;
	@Autowired
	private ScenarioRepository scenarioDao;

	private Mos mos;

	@BeforeMethod
	public void beforeMethod() {
		Scenario scenario1 = new Scenario();
		scenario1.setScenario("scenario1");
		scenario1.addScenarioParameter(new ScenarioParameters());
		scenarioDao.save(scenario1);

		Video video = new Video();
		video.setName("video1");
		video.addScenarion(scenario1);
		videoDao.save(video);

		Questionary questionary = new Questionary();
		questionary.setAge("28");
		questionary.setDate(new Date());
		questionary.setEmail("pavelseda@eeeeeeeeetest.cz");
		questionary.setGender("muz");
		questionary.setSchool("stredni_skola");
		questionary.setUserConnection("wifi_pripojeni");
		questionaryDao.save(questionary);

		mos = new Mos();
		mos.setMosValue("5");
		mos.setQuestionary(questionary);
		mos.setVideo(video);
		mos.setScenario(scenario1);
	}

	@AfterMethod
	public void afterMethod() {
		mosDao.deleteAll();
	}

	@Test
	public void testCreate() {
		mosDao.save(mos);
		Assert.assertNotNull(em.find(Mos.class, mos.getId()));
	}

	@Test
	public void testFindAll() {
		mosDao.save(mos);
		Assert.assertEquals(mosDao.findAll().size(), 1);
	}

	@Test
	public void testFindById() {
		em.persist(mos);
		Mos found = mosDao.findOne(mos.getId());
		Assert.assertEquals(mos, found);
	}

	@Test
	public void testUpdate() {
		mosDao.save(mos);
		mos.setMosValue("3");
		mosDao.save(mos);
		Assert.assertEquals(em.find(Mos.class, mos.getId()).getMosValue(),
				mos.getMosValue());
	}

	@Test
	public void testRemove() {
		em.persist(mos);
		Assert.assertNotNull(mosDao.findOne(mos.getId()));
		mosDao.delete(mos);
		Assert.assertNull(mosDao.findOne(mos.getId()));
	}

}
