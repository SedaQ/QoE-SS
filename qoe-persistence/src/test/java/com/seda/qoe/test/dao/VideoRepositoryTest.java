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

import com.seda.qoe.dao.VideoRepository;
import com.seda.qoe.entity.Video;

/**
 * getRandomVideo() cannot be tested because it is dependend on MySQL dialect so
 * it dont fit with Embedded Derby DB.
 * 
 * @author Pavel Šeda (441048)
 *
 */
@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContextTest.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class VideoRepositoryTest extends AbstractTestNGSpringContextTests {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private VideoRepository videoDao;

	private Video video;
	private Video video2;

	@BeforeMethod
	public void beforeMethod() {
		video = new Video();
		video.setName("aspen");
		video.addVideoSource("source.mp4");

		video2 = new Video();
		video2.setName("collen burn");
		video2.addVideoSource("source2.mp4");

		videoDao.save(video);
		videoDao.save(video2);
	}

	@AfterMethod
	public void afterMethod() {
		videoDao.deleteAll();
	}

	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Video.class, video.getId()));
		Assert.assertNotNull(em.find(Video.class, video2.getId()));
	}

	@Test
	public void testGetAll() {
		Assert.assertEquals(videoDao.findAll().size(), 2);
	}

	@Test
	public void testUpdate() {
		video.setName("anotherName");
		videoDao.save(video);
		Assert.assertEquals(em.find(Video.class, video.getId()).getName(),
				video.getName());
	}

	@Test
	public void testRemove() {
		em.persist(video);
		Assert.assertNotNull(em.find(Video.class, video.getId()));
		videoDao.delete(video);
		Assert.assertNull(em.find(Video.class, video.getId()));
	}

}
