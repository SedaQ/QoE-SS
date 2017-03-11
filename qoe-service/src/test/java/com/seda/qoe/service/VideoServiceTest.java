package com.seda.qoe.service;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.dao.VideoRepository;
import com.seda.qoe.entity.Video;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class VideoServiceTest {

	@Mock
	private VideoRepository videoDao;

	@Mock
	private VideoService videoService;

	Video v1;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		videoService = new VideoServiceImpl(videoDao);
	}

	@BeforeMethod
	public void beforeMethod() {
		v1 = new Video();
		v1.setName("aspen");
		v1.addVideoSource("scenario.mp4");
	}

	@AfterMethod
	public void afterMethod() {
		reset(videoDao);
	}

	@Test
	public void testCreate() {
		videoService.create(v1);
		verify(videoDao, times(1)).save(any(Video.class));
	}

	@Test
	public void testUpdate() {
		videoService.update(v1);
		verify(videoDao, times(1)).save(any(Video.class));
	}

	@Test
	public void testFindById() {
		videoService.findById(1L);
		verify(videoDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		videoService.findAll("");
		verify(videoDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		videoService.findAll("age==17");
		verify(videoDao, times(1)).findAll(any(Specification.class));
	}

	@Test
	public void testRemove() {
		videoService.remove(v1);
		verify(videoDao, times(1)).delete(any(Video.class));
	}

	@Test
	public void testFindRandomVideo() {
		videoService.findRandomVideo();
		verify(videoDao, times(1)).getRandomVideo();
	}

}
