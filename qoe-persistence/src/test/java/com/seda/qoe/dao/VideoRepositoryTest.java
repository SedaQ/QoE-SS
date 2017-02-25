package com.seda.qoe.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.entity.Video;

@ContextConfiguration(classes = com.seda.qoe.context.PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class VideoRepositoryTest extends AbstractTestNGSpringContextTests{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private VideoRepository videoDao;
	
	Video video;
	Video video2;
	
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
	public void afterMethod(){
		
	}
	
	@Test
	public void testCreate() {
		Assert.assertNotNull(em.find(Video.class, video.getId()));
		Assert.assertNotNull(em.find(Video.class, video2.getId()));
	}
	
	@Test
	public void testGetAll(){
		//Assert.assertEquals(videoDao.findAll().size(), 4);
	}
	
	@Test
	public void testGetRandomVideo(){
		Video returnRandomVideo = videoDao.getRandomVideo();
		System.out.println(returnRandomVideo);
		Assert.assertTrue(videoDao.findAll().contains(returnRandomVideo));
	}

}
