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

@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MosRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private MosRepository mosDao;
	
//	@Autowired
//	private VideoRepository videoDao;
//	
//	@Autowired
//	private QuestionaryRepository questionaryDao;

	private Mos mos;

	@BeforeMethod
	public void beforeMethod() {
		//Video video = new Video();
		//Questionary q = new Questionary();

		mos = new Mos();
		mos.setMosValue("5");
		//mos.setVideo(video);
		//mos.setQuestionary(q);
		//mosDao.deleteAll();
	}
	
	@AfterMethod
	public void afterMethod(){
		
	}
	
	@Test
	public void testCreate() {
		mosDao.save(mos);
		Assert.assertNotNull(em.find(Mos.class, mos.getId()));
	}
	
	@Test
	public void testFindAll() {
		mosDao.save(mos);
		/*
		Video video = new Video();
		video.setVideoSource("mp4/aspen");
		videoDao.save(video);
		
		Questionary q = new Questionary();
		q.setAge("24");
		q.setGender("man");
		q.setSchool("VUT");
		questionaryDao.save(q);
		*/
		
		Mos mos1 = new Mos();
		mos1.setMosValue("1223");
		//mos1.setVideo(video);
		//mos1.setQuestionary(q);

		mosDao.save(mos1);

		Assert.assertNotNull(mosDao.findAll());
	}

	@Test
	public void testFindById() {
		em.persist(mos);
		Mos found = mosDao.findOne(mos.getId());
		Assert.assertEquals(mos, found);
	}

	@Test
	public void testRemove() {
		Mos mos1 = new Mos();
		mos1.setMosValue("4");
		mosDao.save(mos1);

		Assert.assertNotNull(mosDao.findOne(mos1.getId()));
		mosDao.delete(mos1);
		Assert.assertNull(mosDao.findOne(mos1.getId()));
	}

	@Test
	public void testUpdate() {
		mosDao.save(mos);
		mos.setMosValue("3");
		mosDao.save(mos);
		Assert.assertEquals(mosDao.findOne(mos.getId()).getMosValue(), "3");
	}

}
