package com.seda.qoe.facade;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.config.BeanMappingConfiguration;
import com.seda.qoe.dto.video.VideoCreateDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.entity.Video;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.VideoService;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class VideoFacadeTest extends AbstractTestNGSpringContextTests {

	@Mock
	private VideoService videoService;
	@Mock
	private BeanMapping beanMapping;

	private VideoFacade videoFacade;
	private VideoDTO videoDTO;
	private VideoCreateDTO videoCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new Video()).when(beanMapping).mapTo(any(VideoDTO.class),
				eq(Video.class));

		videoFacade = new VideoFacadeImpl(videoService, beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		videoDTO = new VideoDTO();
		videoCreateDTO = new VideoCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(videoService);
	}

	@Test
	public void testCreate() {
		videoFacade.create(videoCreateDTO);
		verify(videoService, times(1)).create(
				beanMapping.mapTo(videoCreateDTO, Video.class));
	}

	@Test
	public void testUpdate() {
		videoFacade.update(1L);
		verify(videoService, times(1)).update(any(Video.class));
	}

	@Test
	public void testFindById() {
		videoFacade.getVideoById(Long.MAX_VALUE);
		verify(videoService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		videoFacade.getAllVideo("");
		verify(videoService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testFindRandomVideo() {
		videoFacade.findRandomVideo();
		verify(videoService, times(1)).findRandomVideo();
	}

	@Test
	public void testRemove() {
		videoFacade.deleteVideo(Long.MAX_VALUE);
		verify(videoService, times(1)).remove(any(Video.class));
	}

}
